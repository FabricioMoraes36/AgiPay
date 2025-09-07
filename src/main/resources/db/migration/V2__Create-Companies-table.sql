CREATE TABLE Companies (
    company_id UUID PRIMARY KEY,
    company_name VARCHAR(255),
    company_cnpj VARCHAR(18) NOT NULL UNIQUE,
    company_balance DECIMAL(19,2)
);
