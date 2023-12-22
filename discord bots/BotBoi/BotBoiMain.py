import discord
import random
import time
from discord.ext.commands import Bot
from discord.ext import commands

bot = commands.Bot(command_prefix='.')



#varibles
    #delete
global delete_amount
    #spam
global spam_number_current
global spam_name
    #calculate
global calculate_number_one
global calculate_number_two
global calculate_type_of_math
global serious_or_not
global plus_or_minus
    #pokemon
global pokemons
global poke_choice

#test-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
@bot.command()
async def test(ctx):
    await ctx.send(f'This works. {(round(bot.latency) * 1000)} ms')
    await ctx.send("https://imgur.com/9hqxsPt")

#message delete-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
@bot.command()
async def delete(ctx, delete_amount=6):
    await ctx.channel.purge(limit=delete_amount)

#calc-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
@bot.command()
async def calculate(ctx, calculate_number_one, calculate_number_two, calculate_type_of_math, serious_or_not=2):
    global calculate_solution

    #REGULAR MATH
    if serious_or_not == 1:
        if calculate_type_of_math == "add":
            calculate_solution = int(calculate_number_one) + int(calculate_number_two)
            await ctx.send(str(calculate_solution))

        if calculate_type_of_math == "sub":
            calculate_solution = int(calculate_number_one) - int(calculate_number_two)
            await ctx.send(str(calculate_solution))

        if calculate_type_of_math == "mul":
            calculate_solution = int(calculate_number_one) * int(calculate_number_two)
            await ctx.send(str(calculate_solution))

        if calculate_type_of_math == "div":
            calculate_solution = int(calculate_number_one) / int(calculate_number_two)
            await ctx.send(str(calculate_solution))

#search-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
@bot.command()
async def web(ctx, query = "N/A", query_2 = "N/A", query_3 = "N/A", query_4 = "N/A", query_5 = "N/A", query_6 = "N/A", query_7 = "N/A", query_8 = "N/A", query_9 = "N/A", query_10 = "N/A"):

    if query != "N/A" and query_2 != "N/A" and query_3 != "N/A" and query_4 != "N/A" and query_5 != "N/A" and query_6 != "N/A" and query_7 != "N/A" and query_8 != "N/A" and query_9 != "N/A" and query_10 != "N/A":
        await ctx.send("http://google.com/search?q=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "+" + str(query_6) + "+" + str(query_7) + "+" + str(query_8) + "+" + str(query_9) + "+" + str(query_10) + "&oq=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "+" + str(query_6) + "+" + str(query_7) + "+" + str(query_8) + "+" + str(query_9) + "+" + str(query_10) + "&aqs=chrome..69i57.6976j0j1&sourceid=chrome&ie=UTF-8")

    elif query != "N/A" and query_2 != "N/A" and query_3 != "N/A" and query_4 != "N/A" and query_5 != "N/A" and query_6 != "N/A" and query_7 != "N/A" and query_8 != "N/A" and query_9 != "N/A":
        await ctx.send("http://google.com/search?q=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "+" + str(query_6) + "+" + str(query_7) + "+" + str(query_8) + "+" + str(query_9) + "&oq=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "+" + str(query_6) + "+" + str(query_7) + "+" + str(query_8) + "+" + str(query_9) + "&aqs=chrome..69i57.6976j0j1&sourceid=chrome&ie=UTF-8")

    elif query != "N/A" and query_2 != "N/A" and query_3 != "N/A" and query_4 != "N/A" and query_5 != "N/A" and query_6 != "N/A" and query_7 != "N/A" and query_8 != "N/A":
        await ctx.send("http://google.com/search?q=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "+" + str(query_6) + "+" + str(query_7) + "+" + str(query_8) + "&oq=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "+" + str(query_6) + "+" + str(query_7) + "+" + str(query_8) + "&aqs=chrome..69i57.6976j0j1&sourceid=chrome&ie=UTF-8")

    elif query != "N/A" and query_2 != "N/A" and query_3 != "N/A" and query_4 != "N/A" and query_5 != "N/A" and query_6 != "N/A" and query_7 != "N/A":
        await ctx.send("http://google.com/search?q=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "+" + str(query_6) + "+" + str(query_7) + "&oq=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "+" + str(query_6) + "+" + str(query_7) + "&aqs=chrome..69i57.6976j0j1&sourceid=chrome&ie=UTF-8")

    elif query != "N/A" and query_2 != "N/A" and query_3 != "N/A" and query_4 != "N/A" and query_5 != "N/A" and query_6 != "N/A":
        await ctx.send("http://google.com/search?q=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "+" + str(query_6) + "&oq=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "+" + str(query_6) + "&aqs=chrome..69i57.6976j0j1&sourceid=chrome&ie=UTF-8")

    elif query != "N/A" and query_2 != "N/A" and query_3 != "N/A" and query_4 != "N/A" and query_5 != "N/A":
        await ctx.send("http://google.com/search?q=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "&oq=" + str(query) + "+" + str(query_2)  + "+" + str(query_3) + "+" + str(query_4) + "+" + str(query_5) + "&aqs=chrome..69i57.6976j0j1&sourceid=chrome&ie=UTF-8")

    elif query != "N/A" and query_2 != "N/A" and query_3 != "N/A" and query_4 != "N/A":
        await ctx.send("https://www.google.com/search?q=" + str(query) + "+" + str(query_2) + "+" + str(query_3) + "+" + str(query_4) + "&oq=" + str(query) + "+" + str(query_2) + "+" + str(query_3) + "+" + str(query_4) + "&aqs=chrome..69i57.3711j0j9&sourceid=chrome&ie=UTF-8")

    elif query != "N/A" and query_2 != "N/A" and query_3 != "N/A":
        await ctx.send("https://www.google.com/search?q=" + str(query) + "+" + str(query_2) + "+" + str(query_3) + "&oq=" + str(query) + "+" + str(query_2) + "+" + str(query_3) + "&aqs=chrome..69i57.6317j0j9&sourceid=chrome&ie=UTF-8")

    elif query != "N/A" and query_2 != "N/A":
        await ctx.send("https://www.google.com/search?q=" + str(query) + "+" + str(query_2) + "&oq=" + str(query) + "+" + str(query_2) + "&aqs=chrome..69i57j69i64.1104j0j9&sourceid=chrome&ie=UTF-8")

    elif query != "N/A":
        await ctx.send("https://www.google.com/search?q=" + str(query) + "&oq=" + str(query) + "&aqs=chrome..69i57.495j0j1&sourceid=chrome&ie=UTF-8")

#pokemon---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
@bot.command()
async def pokemon(ctx):
    pokemons = ['Eevee', 'Solgaleo', 'Arceus', 'Reshiram', 'Ash Greninja',
                'Raquaza', 'Groudon', 'Dialga', 'Palkia', 'Dragonite',
                'Mewtwo', 'Mew', 'Kyogre', 'Arcanine', 'Hoopa',
                'Lugia', 'Steelix', 'Tyrantitar', 'Rhyperior', 'Metagross'
                'Charizard', 'Lucario', 'Lunala', 'Latios', 'Latias',
                'Garchomp', 'Gengar', 'Melmetal', 'Darkrai', 'Zekrom',
                'Machamp', 'Blastoise', 'Zekram', 'Deoxys', 'Scizor',
                'Sceptile', 'Entei', 'Suicune', 'Raikou', 'Kyruem']

    poke_choice = random.choice(pokemons)

    if poke_choice.startswith("A"):
        await ctx.send("I caught an " + str(poke_choice) + "!")

    elif poke_choice.startswith("E"):
        await ctx.send("I caught an " + str(poke_choice) + "!")

    elif poke_choice.startswith("I"):
        await ctx.send("I caught an " + str(poke_choice) + "!")

    elif poke_choice.startswith("O"):
        await ctx.send("I caught an " + str(poke_choice) + "!")

    elif poke_choice.startswith("U"):
        await ctx.send("I caught an " + str(poke_choice) + "!")

    else:
        await ctx.send("I caught a " + str(poke_choice) + "!")


#


#MAIN STARTUP!!!-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
@bot.event
async def on_ready():
    print("Ready!")


bot.run("NzM4ODI5MTM5MTY3MDE5MDYw.XyRmQQ.SCDj6AyShNMR9BEmZQTjUynZMzs")
