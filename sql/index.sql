-- User table indexes
CREATE INDEX IF NOT EXISTS idx_user_email ON users(email);

-- Task table indexes
CREATE INDEX IF NOT EXISTS idx_task_status ON task(status);
CREATE INDEX IF NOT EXISTS idx_task_projet_id ON task(projet_id);
CREATE INDEX IF NOT EXISTS idx_task_user_id ON task(user_id);

-- Projet table indexes
CREATE INDEX IF NOT EXISTS idx_projet_name ON projet(name);

-- Join table indexes
CREATE INDEX IF NOT EXISTS idx_users_projet ON users_projet(user_id, projet_id);