SELECT s.student_name, b.book_title
FROM Student s
JOIN Library l ON s.student_id = l.student_id
JOIN Books b ON l.book_id = b.book_id;

DELETE FROM library WHERE student_id = 11;


