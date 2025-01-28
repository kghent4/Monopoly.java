Display.java instance variables that you will use:

    static Property[][] properties = new Property[11][11];
    - You need to fill this with the properties that you create!

    static ArrayList<Player> players = new ArrayList<Player>(1);
    - You need to fill this with the players that you create!


*******************************************************************


Display.java methods that you will use:

    public static void landOnUnownedProperty(Property p)
    - Call this method if the property landed on can be bought!

    public static void landOnOwnedProperty(Property p)
    - Call this method if the property landed on is owned by someone!

    public static void landOnSpecialProperty(Property p, String text)
    - Call this method if the property landed on is a special property! Give it the text that you want to display.

    public static void setDiceDisplay(Player p, int number)
    - Call this method to update the display when the dice are rolled! Tell it who rolled and what they rolled.


*******************************************************************



Important Modifications

    We're not going to worry about mortgaging properties or hotels right now!
    In addition, we will use the following rent scheme:
        1 house - double rent
        2 houses - triple rent
        etc.
        All properties in a set owned - double rent (after calculating house multiplier)



*******************************************************************



Properties (in order)          Cost to buy          Base Rent           Color               Cost to buy a house
    Go                              --                  --                  --                  --
    Mediterranean Avenue            60                  2                   (102,51,0)          50
    Community Chest                 --                  --                  --                  --
    Baltic Avenue                   60                  4                   (102,51,0)          50
    Income Tax                      --                  --                  --                  --
    Reading Railroad                200                 25                  --                  --
    Oriental Avenue                 100                 6                   (0,153,204)         50
    Chance                          --                  --                  --                  --
    Vermont Avenut                  100                 6                   (0,153,204)         50
    Connecticut Avenue              120                 8                   (0,153,204)         50
    Jail                            --                  --                  --                  --
    St. Charles Place               140                 10                  (204,68,204)        100
    Electric Company                150                 2xdice              --                  --
    States Avenue                   140                 10                  (204,68,204)        100
    Virginia Avenue                 160                 12                  (204,68,204)        100
    Pennsylvania Railroad           200                 25                  --                  --
    St. James Place                 180                 14                  (204,68,204)        100
    Community Chest                 --                  --                  --                  --
    Tennessee Avenue                180                 14                  (204,68,204)        100
    New York Avenue                 200                 16                  (204,68,204)        100
    Free Parking                    --                  --                  --                  --
    Kentucky Avenue                 220                 18                  (255,0,0)           150
    Chance                          --                  --                  --                  --
    Indiana Avenue                  220                 18                  (255,0,0)           150
    Illinois Avenue                 240                 20                  (255,0,0)           150
    B&O Railroad                    200                 25                  --                  --
    Atlantic Avenue                 260                 22                  (255,255,51)        150
    Ventnor Avenue                  260                 22                  (255,255,51)        150
    Water Works                     150                 2xdice              --                  --
    Marvin Gardens                  280                 24                  (255,255,51)        150
    Go to Jail                      --                  --                  --                  --
    Pacific Avenue                  300                 26                  (51,153,51)         200
    North Carolina Avenue           300                 26                  (51,153,51)         200
    Community Chest                 --                  --                  --                  --
    Pennsylvania Avenue             320                 28                  (51,153,51)         200
    Short Line Railroad             200                 25                  --                  --
    Chance                          --                  --                  --                  --
    Park Place                      350                 35                  (51,153,51)         200
    Luxury Tax                      --                  --                  --                  --
    Boardwalk                       400                 50                  (51,153,51)         200
