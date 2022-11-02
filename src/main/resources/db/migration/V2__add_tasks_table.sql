create table if not exists t_tasks (
   id bigserial primary key,
   name text not null,
   creation_date timestamp,
   user_id bigint not null,
   company_name text,
   stock_volume text,
   constraint fk_user foreign key(user_id) references t_users(id)
)