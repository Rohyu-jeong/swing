-- SQL 연산자
-- BETWEEN : A와 B사이의 값을 조회할 때 사용
-- IN : OR을 대신해서 사용하는 연산자
-- LIKE : 유사검색

-- 사원테이블에서 06년도에 입사한 사원들의 정보를 사번, 이름, 직종, 입사일 순으로 출력
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, HIRE_DATE FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN TO_DATE ('20060101', 'YYYYMMDD') AND TO_DATE('20061231', 'YYYYMMDD');
-- WHERE HIRE_DATE >= TO_DATE('20060101', 'YYYYMMDD') AND HIRE_DATE <= TO_DATE('20061231', 'YYYYMMDD');

-- 사원테이블에서 급여가 5000 이상이고 6000이하인 사원의 정보를 사번, 이름, 급여 순으로 출력
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 5000 AND 6000;

-- IN
-- 직종이 SA_MAN, IT_PROG인 사원들의 정보를 이름, 직종순으로 출력
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID IN('SA_MAN', 'IT_PROG');
-- WHERE JOB_ID = 'SA_MAN' OR JOB_ID = 'IT_PROG';

-- 급여가 2200, 3200, 5000을 받는 사원들의 정보를 이름, 직종, 급여 순으로 출력하세요
SELECT FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY IN (2200, 3200, 5000);

-- 유사검색
-- 부분적으로 일치하는 속성을 찾을 때 사용된다.
-- % : 모든 값
-- _ : 하나의 값

-- 'A%' : A로 시작하는 모든 데이터
-- '%A' : A로 끝나는 모든 데이터
-- '%A%' : A를 포함하는 모든 데이터
-- '%A%I%' : A와 I를 포함하는 모든 데이터
-- 'A_' : A로 시작하는 두 글자 데이터
-- '_A' : A로 끝나는 두 글자 데이터
-- '_A_' :  두 번째에 A가 있는 세 글자 데이터
-- '__A' : A로 끝나는 세 글자 데이터

-- 사원테이블에서 사원들의 이름 중 M으로 시작하는 사원들의 정보를 사번, 이름, 직종 순으로 출력
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'M%';

-- 사원테이블에서 이름이 d로 끝나는 사원의 사번, 이름, 직종을 출력
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%d';

-- 이름의 첫 글자가 M이면서 총 7글자의 이름을 가진 사원의 정보를 사번, 이름순으로 출력
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'M______';

-- 이름에 소문자 o가 들어가면서 이름이 a로 끝나는 사원들의 정보를 이름, 급여 순으로 조회
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%o%a';

-- 사원테이블에서 이름의 세번째 글자에 a가 들어가는 사원의 정보를 사번, 이름 순으로 출력
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '__a%';

-- 이름이 H로 시작하면서 6글자 이상인 사원들의 정보를 사번, 이름순으로 조회
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEE
WHERE FIRST_NAME LIKE 'H_____%';

-- 사원테이블에서 이름에 S가 포함되어있지 않은 사원들의 정보를 사번, 이름으로 검색
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEE
WHERE FIRST_NAME NOT LIKE '%s%';

-- OR연산자를 통해 여러 조건을 검색
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEE
WHERE FIRST_NAME LIKE '%el%' OR FIRST_NAME LIKE '%en%';

-- REGEXP_LIKE("문자열", "정규표현식", "일치옵션")
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEE
WHERE REGEXP_LIKE (FIRST_NAME, 'el|en');

-- A% -> ^A
-- %A -> A$
-- %A% -> A

-- INSERT
-- 테이블에 데이터를 추가할 때 사용하는 키워드
-- INSERT INTO 테이블명(컬럼명1, 컬럼명2 ...) VALUES(값1, 값2...); DEFAULT 사용할 때
-- INSERT INTO 테이블명 VALUES(값1, 값2...); DEFAULT값 사용 불가

INSERT INTO TBL_STUDENT (ID, NAME, MAJOR, GENDER, BIRTH)
VALUES (0, '홍길동', '컴퓨터공학과', 'M', TO_DATE('1980-01-02', 'YYYY-MM-DD'));

SELECT * FROM TBL_STUDENT;

INSERT INTO TBL_STUDENT (ID, NAME, MAJOR, GENDER, BIRTH)
VALUES (1, '김길동', '컴퓨터공학과', 'M', TO_DATE('1980-01-02', 'YYYY-MM-DD'));

INSERT INTO TBL_STUDENT (ID, NAME, MAJOR, GENDER, BIRTH)
VALUES (2, '홍길동', '컴퓨터공학과', 'W', TO_DATE('1999-01-02', 'YYYY-MM-DD'));

INSERT INTO TBL_STUDENT (ID, NAME, MAJOR, BIRTH)
VALUES (3, '박길동', '컴퓨터공학과', TO_DATE('2000-02-06', 'YYYY-MM-DD'));

INSERT INTO TBL_STUDENT VALUES (4, '이길동', '컴퓨터공학과', 'M', TO_DATE('2000-02-06', 'YYYY-MM-DD'));

-- 테이블에서 SELECT한 데이터를 INSERT하는 경우
-- SELECT한 테이블의 속성의 개수와 INSERT 하려고 하는 테이블의 속성의 개수와 이름이 일치

-- UPDATE
-- 테이블의 데이터를 수정할 때 사용하는 키워드
-- UPDATE 테이블명
-- SET 기존컬럼명 = 새로운 값,
-- 기존컬럼명 = 새로운 값,
-- 기존컬럼명 = 새로운 값,
-- 기존컬럼명 = 새로운 값,
-- WHERE 조건식

-- WHERE절이 없으면 모든 데이터에 대해 수정이 된다.

UPDATE TBL_STUDENT
SET NAME = '제임스';

SELECT * FROM TBL_STUDENT;

UPDATE TBL_STUDENT
SET MAJOR = '산업경영공학과'
WHERE ID = 1;

-- DELETE
-- 테이블에서 데이터를 삭제하고자 할 때 사용하는 명령어
-- 조건에 해당하는 하나의 행이 삭제
-- DELETE FROM 테이블명 WHERE 조건식

DELETE FROM TBL_STUDENT
WHERE ID = 0;

DELETE FROM TBL_STUDENT;

-- ORDER BY(정렬)
-- 질의 결과에 반환되는 행들을 특정 기준으로 정렬하고자 할 때 사용
-- ORDER BY절은 SELECT 절의 가장 마지막에 기술
-- ASC : 오름차순(DEFAULT 생략 가능)
-- DESC : 내림차순(생략 불가)

-- 사원테이블에서 급여를 많이 받는 사원순으로 사번, 이름, 급여, 입사일을 출력하세요
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE FROM EMPLOYEES ORDER BY SALARY DESC, HIRE_DATE;

-- 사원테이블에서 부서번호가 빠른순, 부서번호가 같다면 직종이 빠른순, 직종까지 같다면 급여를 많이 받는 순으로
-- 사번, 이름, 부서번호, 직종, 급여순으로 출력
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, JOB_ID, SALARY
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID, JOB_ID, SALARY DESC;

-- 급여가 15000이상인 사원들의 사번, 이름, 급여, 입사일을 입사일이 빠른 순으로 조회
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE
FROM EMPLOYEES
WHERE SALARY >= 15000
ORDER BY HIRE_DATE;
