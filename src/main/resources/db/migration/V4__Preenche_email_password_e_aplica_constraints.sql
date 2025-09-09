-- 1. Preencher valores temporários para registros antigos
UPDATE users
SET email = CONCAT('temp_', id, '@example.com')
WHERE email IS NULL;

UPDATE users
SET password = 'changeme'
WHERE password IS NULL;

-- 2. Tornar colunas obrigatórias
ALTER TABLE users
ALTER COLUMN email SET NOT NULL,
ALTER COLUMN password SET NOT NULL;

-- 3. Adicionar constraint de unicidade
ALTER TABLE users
ADD CONSTRAINT users_email_unique UNIQUE (email);
