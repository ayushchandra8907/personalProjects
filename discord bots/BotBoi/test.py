import discord
from discord.ext.commands import Bot
from discord.ext import commands

bot = commands.Bot(command_prefix='!')


@bot.command()
async def test(ctx):
    await ctx.send("test good")


@bot.event
async def on_ready():
    print("ready")

bot.run("NzM4ODI5MTM5MTY3MDE5MDYw.XyRmQQ.SCDj6AyShNMR9BEmZQTjUynZMzs")
