math.randomseed(os.clock()^5)

counter = 0

local charset = {}  do -- [0-9a-zA-Z]
    for c = 48, 57  do table.insert(charset, string.char(c)) end
    for c = 65, 90  do table.insert(charset, string.char(c)) end
    for c = 97, 122 do table.insert(charset, string.char(c)) end
end

local function randomString(length)
    if not length or length <= 0 then return '' end
    math.randomseed(os.clock()^5)
    return randomString(length - 1) .. charset[math.random(1, #charset)]
end

request = function()
  theUnique = randomString(100)
  wrk.method = "POST"
  wrk.headers["Content-Type"] = "application/json"

  wrk.body = '{"email":"email_' .. theUnique .. '@gmail.com", "firstName": "Usuario", "lastName":"Lopez","username":"u' .. theUnique ..'_"}'

  return wrk.format("POST", "/v1/people")
end
