INSERT INTO employees
    (title, user_id, company_id)
VALUES
    ('software engineer', (SELECT id FROM users WHERE username = 'john.doe@gmail.com'), (SELECT id FROM companies WHERE name = 'e-corp')),
    ('courier', (SELECT id FROM users WHERE username = 'spider.man@gmail.com'), (SELECT id FROM companies WHERE name = 'e-corp')),
    ('CEO', (SELECT id FROM users WHERE username = 'il.gusevskiy@gmail.com'), (SELECT id FROM companies WHERE name = 'e-corp')),
    ('junior software engineer', (SELECT id FROM users WHERE username = 'bot_1@gmail.com'), (SELECT id FROM companies WHERE name = 'google')),
    ('junior software engineer', (SELECT id FROM users WHERE username = 'bot_2@gmail.com'), (SELECT id FROM companies WHERE name = 'google'));
