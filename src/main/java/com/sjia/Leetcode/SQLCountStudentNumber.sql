#580 Count Student Number in Departments
# https://leetcode.com/problems/count-student-number-in-departments/


# Write a query to print the respective department name
# and number of students majoring in each department for all departments in the department table
# (even ones with no current students).

# Sort your results by descending number of students; if two or more departments have the same number of students,
# then sort those departments alphabetically by department name.


select d.dept_name, count(s.student_id) as student_number
from department d left join student s
on d.dept_id = s.dept_id
group by d.dept_id   # group by d.dept_name    # Is both working?
order by 2 desc, 1;


SELECT dept_name, COUNT(student_id) AS student_number FROM
department AS d LEFT JOIN student AS s ON d.dept_id = s.dept_id
GROUP BY dept_name
ORDER BY student_number DESC, dept_name;




student table:
| student_id | student_name | gender | dept_id |
|------------|--------------|--------|---------|
| 1          | Jack         | M      | 1       |
| 2          | Jane         | F      | 1       |
| 3          | Mark         | M      | 2       |


department table:

| dept_id | dept_name   |
|---------|-------------|
| 1       | Engineering |
| 2       | Science     |
| 3       | Law         |

Output should be:

| dept_name   | student_number |
|-------------|----------------|
| Engineering | 2              |
| Science     | 1              |
| Law         | 0              |

