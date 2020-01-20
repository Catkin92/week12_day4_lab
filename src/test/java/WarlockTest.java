import characters.healers.Cleric;
import characters.magicUsers.Warlock;
import characters.magicUsers.Wizard;
import components.SpellType;
import creatures.Dragon;
import creatures.Ogre;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarlockTest {

    private Warlock warlock;
    private Cleric cleric;
    private Wizard wizard;
    private Ogre ogre;
    private Dragon dragon;

    @Before
    public void before() {
        ogre = new Ogre("Oggy", 6, 15, 20);
        warlock = new Warlock("Harrion", 75, "You've been locked", ogre);
        dragon = new Dragon("Snarly", 4, 25, 30);
        wizard = new Wizard("Harry", 50, "I'm a what?", dragon);
        cleric = new Cleric("Florence", 50, "Yir healed!");
    }

    @Test
    public void canGetName() {
        assertEquals("Harrion", warlock.getName());
    }

    @Test
    public void canReturnMaxHP() {
        assertEquals(75, warlock.getMaxHP());
    }

    @Test
    public void canReturnCatchPhrase() {
        assertEquals("You've been locked", warlock.getCatchPhrase());
    }

    @Test
    public void canReturnCurrentHP() {
        assertEquals(75, warlock.getCurrentHP());
    }

    @Test
    public void canLoseHP() {
        warlock.loseHP(10);
        assertEquals(65, warlock.getCurrentHP());
    }
    //
    @Test
    public void canGainHP() {
        warlock.loseHP(15);
        warlock.gainHP(10);
        assertEquals(70, warlock.getCurrentHP());
    }

    @Test
    public void cannotHealMoreThanMaxHP() {
        warlock.loseHP(10);
        warlock.gainHP(20);
        assertEquals(75, warlock.getCurrentHP());
    }

    @Test
    public void spellsShouldStartEmpty() {
        assertEquals(0, warlock.getSpells().size());
    }

    @Test
    public void hasMythicalCreature() {
        assertEquals(ogre, warlock.getCreature());
    }

    @Test
    public void changeMythicalCreature() {
        warlock.setCreature(dragon);
        assertEquals(dragon, warlock.getCreature());
    }

    @Test
    public void canAddSpell() {
        warlock.addSpell(SpellType.FIREBOLT);
        assertEquals(1, warlock.getSpells().size());
    }

    @Test
    public void canAttack() {
        warlock.addSpell(SpellType.FIREBOLT);
        warlock.attack(cleric, SpellType.FIREBOLT);
        assertEquals(30, cleric.getCurrentHP());
    }

    @Test
    public void magicUserOpponentCanDefend() {
        warlock.addSpell(SpellType.FIREBOLT);
        warlock.attack(wizard, SpellType.FIREBOLT);
        assertEquals(34, wizard.getCurrentHP());
    }
}
