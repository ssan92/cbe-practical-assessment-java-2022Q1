INSERT INTO public.user(
	user_id, username, date_create)
	VALUES (NEXTVAL('user_id_user_seq'), 'Jonathan', '2022-01-04 11:00:00.000000');
INSERT INTO public.user(
	user_id, username, date_create)
	VALUES (NEXTVAL('user_id_user_seq'), 'Eddie', '2022-01-04 11:00:00.000000');
INSERT INTO public.user(
	user_id, username, date_create)
	VALUES (NEXTVAL('user_id_user_seq'), 'Yajaira', '2022-01-04 11:00:00.000000');
	
INSERT INTO public.store(
	store_id, name, category, user_id)
	VALUES (NEXTVAL('store_id_store_seq'), 'store-1', 'cat 1',1);
INSERT INTO public.store(
	store_id, name, category, user_id)
	VALUES (NEXTVAL('store_id_store_seq'), 'store-2', 'cat 2',2);
INSERT INTO public.store(
	store_id, name, category, user_id)
	VALUES (NEXTVAL('store_id_store_seq'), 'store-3', 'cat 3',3);