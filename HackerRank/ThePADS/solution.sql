/*
Enter your query here.
// 직업에 따른 이름을 조회. 알파벳 순으로 정렬된 이름 목록.
// 각각 직업의 빈도수를 조회. 오름차순으로 정렬한 빈도수. (직업별 빈도수, 직업 명 소문자)) 빈도수가 같으면 직업명 순으로 정렬

*/

/*
Enter your query here.
*/
select concat(name,
              "(",
              substring(occupation, 1, 1),
              ")")
from OCCUPATIONS
order by name asc;

select concat("There are a total of ",
              count(*),
              " ",
              lower(occupation),
              "s.")
from OCCUPATIONS
group by OCCUPATION
order by count(occupation), occupation;