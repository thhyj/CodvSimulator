package codv.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import codv.Codv;
import java.sql.*;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static void main(String[] args) {
		try{
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		createApplication();
	}

	private static Lwjgl3Application createApplication() {
		return new Lwjgl3Application(new Codv(), getDefaultConfiguration());
	}

	private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
		Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
		configuration.setTitle("CODV");
		configuration.setWindowedMode(1080, 900);
		configuration.useVsync(false);
		configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
		return configuration;
	}
}