-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(*) AS 'count' FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
HAVING ANIMAL_TYPE IN ('Cat', 'Dog')
ORDER BY ANIMAL_TYPE