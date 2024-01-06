CREATE TABLE fraud_check_history
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id  BIGINT NOT NULL,
    is_fraudster BOOLEAN,
    created_at   DATETIME
);