import discord
from discord.ext.commands import Bot
import smtplib
from discord.ext import commands

email_address = 'waknuckles1020@gmail.com'
email_password = 'Turtlestewisbad134'
reciever = 'ayushchandra2468e@gmail.com'

bot = commands.Bot(command_prefix=".//")


@bot.event
async def on_ready():
    print("online")


@bot.event
async def on_message(message):

    if message.content.startswith('ayush'):
        with smtplib.SMTP('smtp.gmail.com', 587) as smtp:
            smtp.ehlo()
            smtp.starttls()
            smtp.ehlo()
            smtp.login(email_address, email_password)

            subject = "Discord Bot"

            body = "Someone just said your name in the server!"

            msg = f"Subject: {subject}\n\n{body}"

            smtp.sendmail(email_address, reciever, msg)

    elif message.content.startswith('Ayush'):
        with smtplib.SMTP('smtp.gmail.com', 587) as smtp:
            smtp.ehlo()
            smtp.starttls()
            smtp.ehlo()
            smtp.login(email_address, email_password)

            subject = "Discord Bot"

            body = "Someone just said your name in the server!"

            msg = f"Subject: {subject}\n\n{body}"

            smtp.sendmail(email_address, reciever, msg)


    elif message.content.startswith('AYUSH'):
        with smtplib.SMTP('smtp.gmail.com', 587) as smtp:
            smtp.ehlo()
            smtp.starttls()
            smtp.ehlo()
            smtp.login(email_address, email_password)

            subject = "Discord Bot"

            body = "Someone just said your name in the server!"

            msg = f"Subject: {subject}\n\n{body}"

            smtp.sendmail(email_address, reciever, msg)

bot.run("Nzk3OTg2NzUzNzk3NTU0MTk2.X_udEw.p1W9XPeg5utsfF9fhUeDpFg1PCY")
