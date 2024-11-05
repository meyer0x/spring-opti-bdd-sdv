CREATE MATERIALIZED VIEW mv_project_task_count AS
SELECT p.projet_id, p.name as project_name, COUNT(t.task_id) as task_count
FROM projet p
LEFT JOIN task t ON p.projet_id = t.projet_id
GROUP BY p.projet_id, p.name;

-- Create an index on the materialized view for better performance
CREATE INDEX idx_mv_project_task_count ON mv_project_task_count(projet_id);