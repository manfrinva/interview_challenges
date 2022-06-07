SELECT
    MONTH(CAST(t.record_date AS datetime)) as month,
    ROUND(MAX(IF(t.data_type = "max", t.data_value, null)),0) as max,
    ROUND(MIN(IF(t.data_type = "min", t.data_value, null)),0) as min,
    ROUND(AVG(IF(t.data_type = "avg", t.data_value, null)),0) as avg
FROM
temperature_records as t
GROUP BY month

-- There is a table with daily weather data over the last 6 months of 2020, including the maximum, minimum and average temperatures.
-- Write a query that gives month, monthly maximum, monthly minimum, monthly average temperatures for the six months.
-- Note: Round the avarege to the nearest integer:
