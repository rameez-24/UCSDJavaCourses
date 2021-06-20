package module1;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.*;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.*;

public class NewApplet extends PApplet {
	
	public UnfoldingMap map;
	
	public void setup() {
		size(400, 500);
		noSmooth();
		this.background(150);
//		frameRate(0.1f);
//		map = new UnfoldingMap(this, 200, 50, 550, 500, new Google.GoogleMapProvider());
//		map.zoomToLevel(2);
//		MapUtils.createDefaultEventDispatcher(this, map);
//		Location loc = new Location(-38.14f, -73.03f);
//		Marker val = new SimplePointMarker(loc);
//		map.addMarker(val);
//	    int yellow = color(255, 255, 0);
//		val.setColor(yellow);
		fill(220, 120, 0);
		rect(50, 50, 300, 400);
		
		fill(0, 0, 0);
		textSize(20);
		text("Earthquakes by magnitude", 125, 90, 200, 70);
		
		fill(50);
		textSize(15);
		text("==> 5.0+ magnitude",120, 205);
		text("==> 4.0+ magnitude",120, 305);
		text("==> Below 4.0",120, 405);
		
		fill(225, 0, 0);
		ellipse(100, 200, 15, 15);
		fill(255, 255, 0);
		ellipse(100, 300, 10, 10);
		fill(0, 0, 255);
		ellipse(100, 400, 5, 5);
//		MapUtils.createDefaultEventDispatcher(this, map);
//		Marker m = new SimplePointMarker();
		
	}
	
	public void draw() {
//		background(220);
//		map.draw();
//		println(frameRate);
	}
}
