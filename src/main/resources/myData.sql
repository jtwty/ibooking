-- 插入student表数据
INSERT INTO student (password, stu_name, phone, email, date_joined) VALUES
('hashed_password_01', 'StudentName01', 13800000001, 'student01@example.com', NOW()),
('hashed_password_02', 'StudentName02', 13800000002, 'student02@example.com', NOW()),
-- ... 按照同样格式重复至第10条记录
('hashed_password_10', 'StudentName10', 13800000010, 'student10@example.com', NOW());

-- 插入admin表数据
INSERT INTO admin (password) VALUES
('hashed_admin_password_01'),
('hashed_admin_password_02'),
-- ... 按照同样格式重复至第10条记录
('hashed_admin_password_10');

-- 插入classroom表数据
INSERT INTO classroom (id, campus, building) VALUES
(1, '邯郸校区', '教学楼A'),
(2, '江湾校区', '实验楼B'),
-- ... 按照同样格式生成9条不同教室记录
(10, '张江校区', '综合楼J');

-- 注意：由于seat表需要关联classroom表，我们假设已经存在对应的classroom.id
-- 插入seat表数据
INSERT INTO seat (id, class_id, class_campus, class_building) VALUES
(1, 1, '邯郸校区', '教学楼A'),
(2, 1, '邯郸校区', '教学楼A'),
-- ... 按照同样格式生成9条与已存在的classroom关联的座位记录
(10, 10, '张江校区', '综合楼J');