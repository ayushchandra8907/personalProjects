import webbrowser
import time
from datetime import datetime

#alarm function
def alarm():
    webbrowser.open("https://youtu.be/T1h1NJMKtnc")


#get input time
print("What time would you like the alarm to go off? Enter time in HOUR:MINUTE:SECOND format, and in 24 hour time.")
inp = input()
times = inp.split(":")

#logic for getting the time needed until turning on alarm
x = datetime.today()
y = x.replace(hour=int(times[0]), minute=int(times[1]), second=int(times[2]))
delta_t = y - x

secs = delta_t.seconds + 1

print(f"Alarm will go off in {int(secs / 3600)} hours, {int(secs / 60 % 60)} minutes, and {secs % 60} seconds\n")

try:
    time.sleep(secs)  # sleeps until alarm time
    alarm() #plays song of choice

except KeyboardInterrupt:
    print("Program has been ended/disrupted. The alarm will not go off.")
