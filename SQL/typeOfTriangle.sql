SELECT
    CASE
        WHEN A + B <= C
        OR A + C <= B
        OR B + C <= A THEN 'Not A Triangle'
        WHEN A = B
        AND B = C THEN 'Equilateral'
        WHEN A = B
        OR A = C
        or B = C THEN 'Isoceles'
        ELSE 'Scalene'
    END
FROM
    TRIANGLES