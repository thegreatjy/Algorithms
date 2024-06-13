# 176. Second Highest Salary
[문제](https://leetcode.com/problems/second-highest-salary/)

## 스칼라 서브쿼리
select 서브쿼리(스칼라 서브쿼리)를 사용하였다.
스칼라 서브쿼리는 단일값을 반환한다.
실행 순서는 1. 메인쿼리 2. 서브쿼리 이다.

```mysql
select id, (
    select distinct salary
    from Employee
    order by salary desc
    limit 1 offset 1) as SecondHighestSalary
    from Employee
;
```
위 쿼리의 결과는

```mysql
| id | SecondHighestSalary |
| -- | ------------------- |
| 1  | 200                 |
| 2  | 200                 |
| 3  | 200                 |
```

이처럼 서브쿼리는 결과의 행 개수만큼 반복해서 실행된다.
조회되는 행 수가 많을 수록 성능이 떨어지게 된다.
매번 동일한 결과값을 반환한다면 캐싱을 통해 성능을 높일 수 있다.

## null 리턴하기
조건에 맞는 값이 없으면 아무 행도 리턴되지 않는다.
```mysql
select distinct salary as 
    from Employee
    order by salary desc
    limit 1 offset 1;
```
```mysql
| salary |
| ------ |
```

값이 없을 때 null을 리턴하기 위해서는 스칼라 서브쿼리를 사용한다.
```mysql
select (
    select distinct salary
    from Employee
    order by salary desc
    limit 1 offset 1
) as SecondHighestSalary
```
```mysql
| SecondHighestSalary |
| ------------------- |
| null                |
```