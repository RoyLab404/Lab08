# Lab 08 – Bài tập 6.15 đến 6.18

**Sinh viên:** Huỳnh Ngọc Khang – 4651050116  
**Lớp:** CNTT46D

Trong Lab này em làm tiếp chương trình quản lý lịch chiếu ở Chương 6. Qua các bài, em bổ sung khả năng undo cho command, chuyển phần lưu lịch sử vào `CommandProcessor`, rồi để `Program` sử dụng processor đó.

## Bài 6.15 – Thêm undo cho command

Em mở rộng giao diện `Command` bằng `UndoableCommand`, có thêm phương thức `undo()`. Mỗi lệnh cần nhớ thông tin đủ để đưa chương trình về trạng thái trước đó:

- Trong demo, ngày thêm phim ban đầu đang trống nên undo của lệnh thêm chỉ cần gỡ phim mới khỏi ngày đó.
- Lệnh xóa phim lưu lại phim của ngày đó trước khi xóa. Khi undo, lệnh thêm lại phim đã lưu.
- Lệnh xóa toàn bộ lịch chụp một bản sao của `EnumMap` trước khi xóa. Khi undo, lệnh khôi phục các ngày và phim từ bản sao này.

Trong `Exercise15`, em chạy lần lượt các lệnh thêm hai phim, xóa một phim rồi xóa lịch. Sau đó em gọi `undo()` theo thứ tự ngược lại. Chương trình lưu trạng thái sau mỗi thao tác và so sánh với trạng thái thu được sau khi undo để kiểm tra việc khôi phục.

## Bài 6.16 – Tạo CommandProcessor

Ở bài trước, client phải tự gọi `execute()` và `undo()` trên từng command. Bài này gom việc đó vào `CommandProcessor`. Phương thức `consume()` thực thi lệnh rồi lưu lệnh vào danh sách. `undoLast()` lấy lệnh cuối danh sách, gọi `undo()` và bỏ lệnh khỏi lịch sử đã thực hiện.

Nhờ vậy, client chỉ cần gửi command cho processor và yêu cầu undo lệnh gần nhất. Client không cần truy cập danh sách bên trong processor; điều này giúp các lớp ít phụ thuộc vào chi tiết của nhau và tuân theo Law of Demeter. Trong `Exercise16`, em thêm hai phim qua processor, rồi undo hai lần để trở về lịch rỗng.

## Bài 6.17 – Bổ sung redo

Để làm lại một thao tác đã undo, `CommandProcessor2` dùng hai danh sách: một danh sách chứa lệnh đã thực hiện và một danh sách chứa lệnh đã undo. Khi gọi `undoLast()`, lệnh cuối được lấy khỏi danh sách đã thực hiện, undo, rồi chuyển sang danh sách đã undo. `redoLast()` lấy lệnh cuối trong danh sách đã undo, thực thi lại và đưa nó về danh sách đã thực hiện.

Cách lấy lệnh cuối cùng ra trước giữ đúng thứ tự khi undo/redo nhiều thao tác liên tiếp. Mã mẫu `CommandProcessor2` chưa xóa các lệnh redo nếu client thực hiện một command mới sau khi undo. Trong `BasicCommandProcessor` của bài 6.18, em xóa danh sách redo khi nhận command mới để tránh làm lại một nhánh thao tác cũ. Trong `Exercise17`, em thêm phim, undo thao tác đó rồi redo; trạng thái sau redo được so sánh với trạng thái ban đầu sau khi thêm.

## Bài 6.18 – Đưa thao tác undo/redo vào Program

Nếu client phải tự tạo command và gửi cho processor, giao diện sử dụng `Program` sẽ không còn đơn giản như ban đầu. Vì vậy, `Program` cung cấp lại các phương thức `add()`, `remove()` và `clear()`. Mỗi phương thức tạo command tương ứng rồi chuyển cho `CommandProcessor`. Hai phương thức `undoLast()` và `redoLast()` của `Program` cũng chỉ ủy quyền cho processor.

Để `Program` không phải vừa quản lý lịch chiếu vừa tự quản lý hai danh sách lịch sử, em tách `CommandProcessor` thành interface và cài đặt bằng `BasicCommandProcessor`. `Program` nhận processor qua constructor; nó giữ `EnumMap` và tạo command, còn processor thực thi command và quản lý lịch sử. Các factory tạo command được để private để client chỉ dùng giao diện nghiệp vụ của `Program`.

Trang lời giải bài 6.18 chỉ có sơ đồ, không có mã nguồn hoàn chỉnh. Vì vậy các lớp trong package `ex18` là phần em viết thêm theo sơ đồ. Demo thay phim đã có trong một ngày rồi undo để kiểm tra phim cũ được phục hồi; sau đó redo để kiểm tra phim mới được đặt lại.

## Cấu trúc project

`Show`, `Movie` và `Command` nằm trong package `designbook.solutions6` để các phần dùng chung. Mỗi bài có package riêng (`ex15` đến `ex18`) để giữ lại phiên bản processor tương ứng mà không bị trùng tên lớp. Mã `Show` và `Movie` dựa trên ví dụ đi kèm giáo trình; các lời giải bài 6.15–6.17 dựa theo mã tham khảo DesignBook.

## Mở và chạy trong Eclipse

1. Chọn **File → Import → General → Existing Projects into Workspace**.
2. Chọn thư mục `Practice/Lab08`, chọn project **Lab08** rồi nhấn **Finish**.
3. Project đặt mức Java 21. Nếu Eclipse báo thiếu JRE, chọn Java 21 trong **Project → Properties → Java Build Path → Libraries**. Mã mẫu bài 6.16–6.17 dùng `List.removeLast()`, nên cần Java 21 trở lên.
4. Mở một trong các lớp dưới đây, nhấn chuột phải và chọn **Run As → Java Application**:
   - `designbook.solutions6.ex15.Exercise15`
   - `designbook.solutions6.ex16.Exercise16`
   - `designbook.solutions6.ex17.Exercise17`
   - `designbook.solutions6.ex18.Exercise18`

Nếu trạng thái sau undo hoặc redo không khớp với mong đợi, demo sẽ báo lỗi ở Console; nếu đúng, Console in thông báo hoàn tất cho bài tương ứng.

## Tài liệu tham khảo

- [DesignBook, lời giải bài 6.14](https://codesample.info/samples/designbook/solutions6/Exercise14.html)
- [DesignBook, lời giải bài 6.15](https://codesample.info/samples/designbook/solutions6/Exercise15.html)
- [DesignBook, lời giải bài 6.16](https://codesample.info/samples/designbook/solutions6/Exercise16.html)
- [DesignBook, lời giải bài 6.17](https://codesample.info/samples/designbook/solutions6/Exercise17.html)
- [DesignBook, lời giải bài 6.18](https://codesample.info/samples/designbook/solutions6/Exercise18.html)
- [Mã mẫu `Show` và `Movie` đi kèm giáo trình](https://github.com/prmr/DesignBook/tree/master/exercise-code/chapter6)

Các file mã mẫu giữ thông tin tác giả và giấy phép gốc.
