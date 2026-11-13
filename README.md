# Lab 08 – Bài tập 6.15 đến 6.18

**Sinh viên:** Huỳnh Ngọc Khang – 4651050116  
**Lớp:** CNTT46D

Trong bài này em làm tiếp mẫu Command ở Chương 6. Các bài 6.15–6.17 có mã tham khảo của DesignBook, em đưa vào project và thêm phần chạy thử. Lời giải bài 6.18 chỉ có sơ đồ, nên em viết thêm các lớp cần thiết theo sơ đồ đó.

## Các phần đã làm

- **Bài 6.15:** `UndoableCommand` bổ sung `undo()`. `Program3` tạo lệnh thêm, xóa và xóa toàn bộ chương trình. Trong `Exercise15`, em chạy các lệnh rồi undo ngược lại và so sánh trạng thái trước, sau mỗi lần undo.
- **Bài 6.16:** `CommandProcessor` chạy lệnh và lưu lại để có thể undo lệnh gần nhất. Client gọi processor, không thao tác trực tiếp với danh sách lệnh.
- **Bài 6.17:** `CommandProcessor2` có thêm danh sách các lệnh đã undo. `redoLast()` lấy lệnh mới nhất trong danh sách đó và chạy lại.
- **Bài 6.18:** `Program` nhận `CommandProcessor` qua constructor. Khi gọi `add()`, `remove()` hoặc `clear()`, Program tạo command rồi chuyển cho processor. `BasicCommandProcessor` giữ lịch sử và thực hiện undo/redo. Phần này em tự bổ sung vì trang lời giải chỉ đưa sơ đồ, không có code.

Các lớp được chia vào package `ex15`, `ex16`, `ex17` và `ex18` để có thể giữ các phiên bản processor của từng bài trong cùng một project Eclipse. `Show`, `Movie` và `Command` dùng chung trong package `designbook.solutions6`.

## Mở project trong Eclipse

1. Chọn **File → Import → General → Existing Projects into Workspace**.
2. Chọn thư mục `Practice/Lab08`.
3. Chọn project **Lab08** rồi nhấn **Finish**.
4. Project đặt mức Java 21. Nếu Eclipse báo thiếu JRE, chọn Java 21 trong **Project → Properties → Java Build Path → Libraries**.

## Chạy chương trình minh họa

Mở từng lớp dưới đây, nhấn chuột phải rồi chọn **Run As → Java Application**:

- `designbook.solutions6.ex15.Exercise15`
- `designbook.solutions6.ex16.Exercise16`
- `designbook.solutions6.ex17.Exercise17`
- `designbook.solutions6.ex18.Exercise18`

Mỗi lớp in kết quả ở Console. Nếu undo hoặc redo cho trạng thái không đúng, chương trình sẽ báo lỗi.

## Tài liệu đã tham khảo

- [DesignBook, lời giải bài 6.14](https://codesample.info/samples/designbook/solutions6/Exercise14.html)
- [DesignBook, lời giải bài 6.15](https://codesample.info/samples/designbook/solutions6/Exercise15.html)
- [DesignBook, lời giải bài 6.16](https://codesample.info/samples/designbook/solutions6/Exercise16.html)
- [DesignBook, lời giải bài 6.17](https://codesample.info/samples/designbook/solutions6/Exercise17.html)
- [DesignBook, lời giải bài 6.18](https://codesample.info/samples/designbook/solutions6/Exercise18.html)
- [Mã mẫu `Show` và `Movie` đi kèm giáo trình](https://github.com/prmr/DesignBook/tree/master/exercise-code/chapter6)

Mã mẫu được giữ thông tin tác giả và giấy phép trong các file nguồn tương ứng.
