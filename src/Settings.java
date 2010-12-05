import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings extends JFrame {
	private static final long serialVersionUID = 4568652071397810155L;

	JCheckBox sound;
	JCheckBox particles;
	JCheckBox asteroidsCollide;
	JButton close;
	JButton apply;
	
	public Settings() {
		setLayout(new BorderLayout());
		setTitle("Settings");
		
		add(settingsPanel(), BorderLayout.NORTH);
		
		add(buttonPanel(), BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}

	private JPanel settingsPanel() {
		JPanel panel = new BlackPanel();
		panel.setLayout(new GridLayout(3, 1));

		sound = new JCheckBox("Enabled Sound");
		sound.setBackground(Color.BLACK);
		sound.setSelected(SoundEffect.isEnabled());
		panel.add(sound);
		
		particles = new JCheckBox("Enabled Particle Effects");
		particles.setBackground(Color.BLACK);
		particles.setSelected(ParticleSystem.isEnabled());
		panel.add(particles);
		
		asteroidsCollide = new JCheckBox("Enabled Asteroid Collisions");
		asteroidsCollide.setBackground(Color.BLACK);
		asteroidsCollide.setSelected(Asteroid.isAsteroidCollisionOn());
		panel.add(asteroidsCollide);		
		
		return panel;
	}

	private JPanel buttonPanel() {
		JPanel panel = new BlackPanel();
		
		apply = new BlackButton("Apply");
		apply.addActionListener(new ButtonHandler(this));
		panel.add(apply);
		
		close = new BlackButton("Close");
		close.addActionListener(new ButtonHandler(this));
		panel.add(close);
		
		return panel;
	}
	
	private class ButtonHandler implements ActionListener {
		JFrame window;
		
		public ButtonHandler(JFrame w) {
			window = w;
		}

		public void actionPerformed(ActionEvent e) {
			 if (e.getSource() == apply) {
				 SoundEffect.isEnabled(sound.isSelected());
				 ParticleSystem.isEnabled(particles.isSelected());
				 Asteroid.isAsteroidsCollisionOn(asteroidsCollide.isSelected());
				 
				 window.dispose();
			 } else if (e.getSource() == close) {
				 window.dispose();
			 }
		}

	}
}
