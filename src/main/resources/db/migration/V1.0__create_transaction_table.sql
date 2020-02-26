create table transactions
(
    transaction_id uuid           not null,
    user_id        bigserial      not null,
    amount         numeric(12, 4) not null,
    description    varchar(255)   not null,
    created_at     timestamp      not null,
    updated_at     timestamp      not null
);

create unique index transactions_transaction_id_uindex
    on transactions (transaction_id);

alter table transactions
    add constraint transactions_pk
        primary key (transaction_id);