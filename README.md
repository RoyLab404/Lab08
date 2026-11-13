# Lab 08 — Command có thể undo và redo

**Môn:** Thiết kế phần mềm  
**Sinh viên:** Huỳnh Ngọc Khang — 4651050116  
**Lớp:** CNTT46D  
**Phạm vi:** DesignBook, Chương 6, bài 6.15–6.18

## Mục tiêu

Project trình bày tiến trình mở rộng mẫu Command: mỗi lệnh có thể undo, `CommandProcessor` quản lý lịch sử, processor hỗ trợ redo, rồi `Program` ủy quyền lịch sử cho processor được truyền vào constructor.

## Mã nguồn theo từng bài

| Bài | Mã nguồn | Cách giải |
|---|---|---|
| 6.15 | `ex15/Program3.java`, `ex15/UndoableCommand.java`, `ex15/Exercise15.java` | Lệnh Add, Remove và Clear ghi lại dữ liệu cần thiết để undo. Demo thực thi chuỗi thao tác rồi hoàn tác ngược lại, so sánh trạng thái sau từng bước. |
| 6.16 | `ex16/CommandProcessor.java`, `ex16/Exercise16.java` | Processor chạy lệnh và giữ lịch sử; client chỉ gọi processor thay vì đọc cấu trúc lịch sử nội bộ. |
| 6.17 | `ex17/CommandProcessor2.java`, `ex17/Exercise17.java` | Thêm danh sách lệnh đã undo; redo lấy lệnh gần nhất và thực thi lại. |
| 6.18 | `ex18/Program.java`, `ex18/CommandProcessor.java`, `ex18/BasicCommandProcessor.java`, `ex18/Exercise18.java` | `Program` giữ thao tác add/remove/clear và tạo command; processor riêng quản lý undo/redo. `Program` nhận interface `CommandProcessor` qua constructor để tránh gom quản lý lịch chiếu và lịch sử vào một lớp. |

`Show`, `Movie` và `Command` được đặt trong package gốc để các phần bài tập dùng chung. `Movie` và `Show` dựa trên mã đi kèm giáo trình; `Command` được tách thành file riêng từ phần lời giải bài 6.14 để Eclipse biên dịch độc lập.

## Import vào Eclipse

1. Chọn **File → Import → General → Existing Projects into Workspace**.
2. Chọn **Select root directory**, trỏ đến thư mục `Practice/Lab08`.
3. Chọn project **Lab08**, rồi nhấn **Finish**.
4. Nếu Eclipse chưa nhận Java 21, vào **Project → Properties → Java Build Path → Libraries**, chọn JRE System Library Java 21.

Project đã có `.project`, `.classpath` và cấu hình compiler mức Java 21. Mã mẫu bài 6.16–6.17 dùng `List.removeLast()`, vì vậy cần Java 21 trở lên.

## Chạy từng bài

Trong Package Explorer, mở lớp tương ứng và chọn **Run As → Java Application**:

- `designbook.solutions6.ex15.Exercise15`
- `designbook.solutions6.ex16.Exercise16`
- `designbook.solutions6.ex17.Exercise17`
- `designbook.solutions6.ex18.Exercise18`

Mỗi demo in thông báo hoàn tất; nếu trạng thái sau undo/redo không đúng, chương trình ném `IllegalStateException`.

## Nguồn và phần bổ sung

- [Lời giải DesignBook bài 6.14](https://codesample.info/samples/designbook/solutions6/Exercise14.html) — giao diện `Command` và cấu trúc `Program2` nền.
- [Lời giải DesignBook bài 6.15](https://codesample.info/samples/designbook/solutions6/Exercise15.html) — `UndoableCommand` và `Program3`; demo trong project bổ sung kiểm tra phục hồi sau từng lần undo theo yêu cầu đề bài.
- [Lời giải DesignBook bài 6.16](https://codesample.info/samples/designbook/solutions6/Exercise16.html) — `CommandProcessor`.
- [Lời giải DesignBook bài 6.17](https://codesample.info/samples/designbook/solutions6/Exercise17.html) — `CommandProcessor2` có redo.
- [Lời giải DesignBook bài 6.18](https://codesample.info/samples/designbook/solutions6/Exercise18.html) — chỉ có sơ đồ thiết kế, không có mã cài đặt. Các lớp trong `ex18` là phần bổ sung theo sơ đồ: processor được trừu tượng hóa thành interface, `Program` nhận processor qua constructor và ủy quyền thao tác undo/redo.
- [Mã mẫu `Show` và `Movie` của giáo trình](https://github.com/prmr/DesignBook/tree/master/exercise-code/chapter6).

Mã nguồn DesignBook giữ thông tin tác giả và giấy phép trong các file có nội dung lấy từ giáo trình. Phần cài đặt bổ sung cho bài 6.18 được ghi rõ ở trên.
