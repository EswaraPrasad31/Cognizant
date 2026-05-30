 -- 1 --
select u.full_name,e.title,e.city,e.start_date
from users u
join registrations r on u.user_id=r.user_id
join events e on r.event_id=e.event_id
where e.status='upcoming'
and u.city=e.city
order by e.start_date;

-- 2 --
select e.event_id,e.title,avg(f.rating) as avg_rating
from events e
join feedback f on f.event_id=e.event_id
group by e.event_id,e.title
having count(f.feedback_id)>=10
order by avg_rating desc;

-- 3 --
select *
from users u
where u.user_id not in
(select distinct user_id 
from registrations
where registration_date>=curdate() - interval 90 day);

-- 4 --
select e.title,count(s.session_id) as session_count
from events e
left join sessions s
on e.event_id=s.event_id
and time(s.start_time) between '10:00:00' and '12:00:00'
group by e.event_id,e.title;

-- 5 --
select u.city,count(r.user_id) as registrations
from users u
join registrations r on r.user_id=u.user_id
group by u.city
order by registrations desc;

-- 6 --
select e.title,r.resource_type,count(*) as resource_count
from events e
join resources r on e.event_id=r.event_id
group by e.title,r.resource_type;

-- 7 --
select u.full_name,f.rating,f.comments,e.title
from users u
join feedback f on u.user_id=f.user_id
join events e on f.event_id=e.event_id
where f.rating<3;

-- 8 --
select e.title,count(s.session_id) as total_sessions
from events e
left join sessions s on s.event_id=e.event_id
where e.status='upcoming'
group by e.event_id,e.title;

-- 9 --
select u.full_name,e.status,count(*) as total_events
from users u
join events e on u.user_id=e.organizer_id 
group by u.full_name,e.status;

-- 10 --
select distinct e.title
from events e
join registrations r on e.event_id=r.event_id
left join feedback f on e.event_id=f.event_id
where f.feedback_id is null;

-- 11 --
select count(u.user_id) as total_users,r.registration_date
from users u
join registrations r on r.user_id=u.user_id
group by r.registration_date
having r.registration_date>='2025-05-08'- interval 7 day;

-- 12 --
select e.title,count(s.session_id) as total_sessions
from events e
join sessions s on s.event_id=e.event_id
group by e.title,e.event_id
having count(s.session_id)=(
select max(session_total)
from(select count(*) as session_total
from sessions group by event_id)x);

-- 13 --
select e.city,avg(f.rating)
from feedback f
join events e on e.event_id=f.event_id
group by e.city;

-- 14 --
select e.title,count(r.registration_id) as total_registration 
from events e
join registrations r on e.event_id=r.event_id
group by e.event_id,e.title
order by total_registration desc
limit 3;

-- 15 --
select s1.event_id,s1.title as session1,s2.title as session2
from sessions s1
join sessions s2 on s1.event_id=s2.event_id
and s1.session_id<s2.session_id
and s1.start_time<s2.end_time
and s1.end_time>s2.start_time;

-- 16 --
select *
from users u
where registration_date>=curdate()-interval 30 day
and not exists(
select 1 from registrations r where r.user_id=u.user_id);

-- 17 --
select speaker_name,count(*) as session_count
from sessions
group by speaker_name
having count(*)>1;

-- 18 --
select e.title
from Events e
left join Resources r
on e.event_id = r.event_id
where r.resource_id is null;

-- 19 --
select e.title,count(distinct r.registration_id) as total_registration,
avg(f.rating) as avg_rating
from events e
left join registrations r
on e.event_id=r.event_id
left join feedback f
on e.event_id=f.event_id
where e.status='completed'
group by e.event_id,e.title;

-- 20 --
select u.full_name,count(distinct r.event_id)as events_attended,
count(distinct f.feedback_id)as feedbacks_submitted
from users u
left join registrations r
on u.user_id=r.user_id
left join feedback f
on u.user_id=f.user_id
group by u.user_id,u.full_name;

-- 21 --
select u.full_name,count(f.feedback_id) as feedback_count
from users u
join feedback f on u.user_id=f.user_id
group by u.user_id,u.full_name
order by feedback_count desc
limit 5;

-- 22 --
select user_id,event_id,count(*) as duplicates
from registrations
group by user_id,event_id
having count(*)>1;

-- 23 --
select year(registration_date) as year,
       month(registration_date) as month,
       count(*) as total_registrations
from registrations
where registration_date >= curdate() - interval 12 month
group by year(registration_date),
         month(registration_date)
order by year, month;

-- 24 --
select e.title,
       avg(timestampdiff(minute,
                         s.start_time,
                         s.end_time)) as avg_duration_minutes
from events e
join sessions s
on e.event_id = s.event_id
group by e.event_id, e.title;

-- 25 --
select e.title
from events e
left join sessions s
on e.event_id = s.event_id
where s.session_id is null;