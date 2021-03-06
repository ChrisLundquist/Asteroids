
/**
 * Author: Chris Lundquist
 * Description: When a PlayerShip collides, we replace the PlayerShip Weapon with
 *              a TripleShotWeapon
 */
public class TripleShotPowerUp extends PowerUp{
	private static final long serialVersionUID = 7120396598193477176L;

	TripleShotPowerUp(Vector pos) {
		super(pos);
		init();
	}

	public TripleShotPowerUp(float x, float y) {
		super(x,y);
		init();
	}
	
	private void init(){
		sprite = Sprite.tripleShotPowerUp();
	}

	@Override
	void applyTo(PlayerShip player) {
		// Give the player the triple shot weapon
		player.weapon = new TripleShotWeapon(player);
		// After the player gets it, delete it
		TripleShotWeapon.incrementShotLevel();
		delete();
	}

	@Override
	void applyTo(Asteroid asteroid) {
		// Nothing to do here, Unless we hate the player
		// or something else cool
	}

	@Override
	void applyTo(Bullet bullet) {
		// Nothing to do here, unless we want to make 3 bullets
		// or something else cool
	}

	@Override
	void applyTo(Actor actor) {
		// Shouldnt get here
		System.out.println("Unhandled PowerUp Case for TripleShotPowerUp");
	}

	@Override
	void applyTo(Bandit bandit) {
		bandit.weapon = new BanditTripleShot(bandit);
		delete();
	}

}
