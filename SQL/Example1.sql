select a.id, a.name, a.address, b.name 
from tbl_student a, tbl_dept b 
where a.studeptid = b.deptid and b.deptid = 9215;

