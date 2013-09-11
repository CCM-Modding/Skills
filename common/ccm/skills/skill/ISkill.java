package ccm.skills.skill;

public abstract class ISkill
{
    /** The name of the skill, set by the constructor */
    protected final String name;
    /** The level of the skill, defaults to 1 */
    protected int level = 1;
    /** The required amount of XP to reach the next Level */
    protected float maxXP = 10;
    /** The current amount of XP */
    protected float xp = 0;

    public ISkill(final String name)
    {// Check for null
        if (name != null)
        {// Check for an empty String
            if (!name.isEmpty())
            {// If everything is ok, set the name and continue :D
                this.name = name;
            } else
            {// If empty kill game
                throw new RuntimeException("FAIELD TO CREATE A SKILL, THE NAME WAS EMPTY");
            }
        } else
        {// If null kill game
            throw new NullPointerException("FAIELD TO CREATE A SKILL, THE NAME WAS NULL");
        }
    }

    /**
     * @return The name of this Skill
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The current level of this Skill
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * @return The current Maximum amount of XP needed to reach the next level
     */
    public float getMaxXP()
    {
        return maxXP;
    }

    /** The current amount of XP */
    public float getCurrentXP()
    {
        return xp;
    }

    /**
     * Sets the current level of the Skill
     * 
     * @param level
     */
    public void setLevel(final int level)
    {
        if (level >= 0)
        {
            this.level = level;
        } else
        {
            throw new RuntimeException(String.format("SET LEVEL FAILED\n Someone tried set the Level of %s to a Negative number!", getName()));
        }

    }

    /**
     * Adds the specified amount to the current level of the Skill
     * 
     * @param amount
     */
    public void levelUp(final int amount)
    {// Make sure that the amount is NOT a negative number :P
        if (amount > 0)
        {// Set the level
            setLevel(getLevel() + amount);
            if (xp <= maxXP)
            {// Make sure that there is no extra XP
                xp = 0;
            } else if (xp > maxXP)
            {// If extra xp is found then carry the extra amount to the next level
                xp -= maxXP;
            }
            // Lastly update the Maximum amount of XP
            updateMaxXP();
        } else
        {
            throw new RuntimeException(String.format("LEVEL UP FAILED\n Someone tried to level %s to a Negative number!", getName()));
        }
    }

    /** This is an internal helper used to updated the maximum amount of XP after a Level Up */
    private void updateMaxXP()
    {
        // TODO Actually update the Max
    }

    /** Increases the Skill's current level by 1 */
    public void levelUp()
    {
        levelUp(1);
    }

    /**
     * Add to the current amount of XP of the Skill
     * 
     * @param amount
     */
    public void addXP(final float amount)
    {// Make sure that the amount is NOT a negative number :P
        if (amount > 0)
        {// Add the input to the current total
            xp += amount;
            if (xp >= maxXP)
            {// then check if it reaches the maximum, if it does then level up
                levelUp();
            }
        } else
        {
            throw new RuntimeException(String.format("ADD XP FAILED\n Someone tried to add a NEGATIVE amount of XP to %s!", getName()));
        }
    }

}