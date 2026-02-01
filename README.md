# a template for creating rsm addons

how to use:  
clone rsm 
.\gradlew build (if ur using intellij just make a gradle configuration or smth, personally my java is fucked and uses like a new version and fails)  
.\gradlew publishToMavenLocal  
now rsm forge is in ur local maven, u can access all its classes and do wtv with ur addon   

# Mixins
 - You must have either fabric-mod.json OR addon.json.
 - If your addon has a fabric-mod.json it cannot be reloaded, as RSM assumes it will use mixins, and you must place it in mods.
 - If your addon does not have a fabric-mod.json, it can be reloaded similarly to a ChatTriggers module, and must be placed in config/rsm/addons
  
command stuff  
the command for addons is `addon  
u can do  
- `addon load <?addon>
- `addon reload <?addon>
- `addon list
- `addon unload <?addon> (you will need to unload the addon before updating it in the folder)  
  
the directory is ".minecraft\config\rsm\addons"  
do lmk if there's any bugs with anything not unloading when u unload stuff, leaks or smth, i made this in 1 day its probably not that good

