INSERT INTO student
(id, sid, sname, email, phone, password)
VALUES
(1, "232101", "zhangsan", "zhangsan@email.com", "18817716655", "123456"),
(2, "232102", "zhangsi", "zhangsi@email.com", "18817726655", "111111"),
(3, "232103", "zhangwu", "zhangwu@email.com", "18817736655", "asdzxc"),
(4, "232104", "zhangliu", "zhangliu@email.com", "18817746655", "password"),
(5, "admin", "admin", "admin@email.com", "123456789", "admin");

INSERT INTO breach
(id, sid, bid)
VALUES
(1, "232101", 1),
(2, "232102", 2);

INSERT INTO seat
(id, zid, rid, socket, today_book, next_book)
VALUES
(1, 1, 1, true, "000000000000000000000000", "000000000000000000000000"),
(2, 2, 2, true, "000000000000000000000000", "000000000000000000000000"),
(3, 3, 3, true, "000000000000000000000000", "000000000000000000000000"),
(4, 2, 1, true, "000000000000000000000000", "000000000000000000000000");

INSERT INTO record
(id, zid, rid, sid, start_time, end_time, booking_date, status)
VALUES
(1, 1, 1, "232101", 10, 13, "2024-05-10", 0),
(2, 2, 2, "232102", 11, 14, "2024-05-11", 0);

INSERT INTO room
(id, rid, rname, seat_amount, open_time, close_time, overnight, max_booking_time, open)
VALUES
(1, 1, "room1", 50, 6, 20, false, 6, true),
(2, 2, "room2", 50, 6, 20, false, 6, true);

