create table if not exists t_users (
    id bigserial primary key,
    name text not null
)