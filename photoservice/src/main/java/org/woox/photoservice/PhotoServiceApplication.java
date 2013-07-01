package org.woox.photoservice;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("photoservice")
public class PhotoServiceApplication extends Application {

	// add from jersey tuto
	// @Override
	// public Set<Class<?>> getClasses() {
	// final Set<Class<?>> classes = new HashSet<Class<?>>();
	// // register root resource
	// classes.add(PhotoServiceWS.class);
	// return classes;
	// }

}
