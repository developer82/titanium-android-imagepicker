package in.prashant.imagepicker;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;



public class Defaults {
	public static final String LCAT = "ImagepickerModule";
	public static final int REQUEST_CODE = 111;
	public static final int QUALITY = 60;
	public static final int SHAPE_SQUARE = 1;		
	public static final int SHAPE_CIRCLE = 2;	

	public static String STATUS_BAR_COLOR;
	public static String BAR_COLOR;		
	public static String BACKGROUND_COLOR;
	public static String COVER_VIEW_COLOR;
	public static String CHECKMARK_COLOR;
	public static String TITLE;
	public static String DONE_BTN_TITLE;
	public static String MAX_IMAGE_MSG;
	public static int GRID_SIZE;
	public static int IMAGE_HEIGHT;
	public static int SHOW_DIVIDER;
	public static int DIVIDER_WIDTH;
	public static int MAX_IMAGE_SELECTION;
	public static int SHAPE;
	public static int CIRCLE_RADIUS;
	public static int CIRCLE_PADDING;
	
	
	protected static class Params {
		static final String STATUS_BAR_COLOR = "colorPrimaryDark";		
		static final String BAR_COLOR = "colorPrimary";
		static final String BACKGROUND_COLOR = "backgroundColor";
		static final String COVER_VIEW_COLOR = "coverViewColor";
		static final String CHECKMARK_COLOR = "checkMarkColor";
		static final String TITLE = "title";
		static final String DONE_BTN_TITLE = "doneButtonTitle";
		static final String GRID_SIZE = "columnCount";
		static final String IMAGE_HEIGHT = "imageHeight";
		static final String SHOW_DIVIDER = "dividerEnabled";
		static final String DIVIDER_WIDTH = "dividerWidth";
		static final String MAX_IMAGE_SELECTION = "maxImageSelection";
		static final String MAX_IMAGE_MSG = "maxImageMessage";
		static final String SHAPE = "shape";
		static final String CIRCLE_RADIUS = "circleRadius";
		static final String CIRCLE_PADDING = "circlePadding";
		
		static final String CALLBACK = "callback";
		static final String IMAGES = "images";
	}	
	

	public static void resetValues() {
		Defaults.STATUS_BAR_COLOR = "";		
		Defaults.BAR_COLOR = "";		
		Defaults.BACKGROUND_COLOR = "#f8f8f8";
		Defaults.COVER_VIEW_COLOR = "#99000000";
		Defaults.CHECKMARK_COLOR = "#ff8f00";		
		Defaults.TITLE = "Select Pictures";
		Defaults.DONE_BTN_TITLE = "Done";
		Defaults.GRID_SIZE = 3;
		Defaults.IMAGE_HEIGHT = 0;
		Defaults.SHOW_DIVIDER = 1;
		Defaults.DIVIDER_WIDTH = 4;
		Defaults.MAX_IMAGE_SELECTION = 0;
		Defaults.MAX_IMAGE_MSG = "You have selected maximum no. of allowed images.";
		Defaults.SHAPE = Defaults.SHAPE_SQUARE;
		Defaults.CIRCLE_RADIUS = 0;
		Defaults.CIRCLE_PADDING = 5;
	}
	
	
	public static void setupInitialValues(Context context, Intent intent) {		
        Bundle bundle = intent.getExtras();
        
		if (null != bundle) {
			Defaults.STATUS_BAR_COLOR = "" + bundle.getString(Params.STATUS_BAR_COLOR);
			Defaults.BAR_COLOR = "" + bundle.getString(Params.BAR_COLOR);
			Defaults.BACKGROUND_COLOR = "" + bundle.getString(Params.BACKGROUND_COLOR);
			Defaults.COVER_VIEW_COLOR = "" + bundle.getString(Params.COVER_VIEW_COLOR);
			Defaults.CHECKMARK_COLOR = "" + bundle.getString(Params.CHECKMARK_COLOR);
			
			Defaults.TITLE = "" + bundle.getString(Params.TITLE);
			Defaults.DONE_BTN_TITLE = "" + bundle.getString(Params.DONE_BTN_TITLE);
			Defaults.MAX_IMAGE_MSG = "" + bundle.getString(Params.MAX_IMAGE_MSG);
			
			Defaults.GRID_SIZE = bundle.getInt(Params.GRID_SIZE);
			Defaults.IMAGE_HEIGHT = bundle.getInt(Params.IMAGE_HEIGHT);
			Defaults.SHOW_DIVIDER = bundle.getInt(Params.SHOW_DIVIDER);
			Defaults.DIVIDER_WIDTH = bundle.getInt(Params.DIVIDER_WIDTH);
			Defaults.MAX_IMAGE_SELECTION = bundle.getInt(Params.MAX_IMAGE_SELECTION);
			Defaults.SHAPE = bundle.getInt(Params.SHAPE);
			Defaults.CIRCLE_RADIUS = bundle.getInt(Params.CIRCLE_RADIUS);
			Defaults.CIRCLE_PADDING = bundle.getInt(Params.CIRCLE_PADDING);
		}
		
		// set max-column count to 5
		if (Defaults.GRID_SIZE > 5) {
			Defaults.GRID_SIZE = 5;
			
		} else if (Defaults.GRID_SIZE <= 1) {
			Defaults.GRID_SIZE = 3;
		}
		
		// set divider width = 0 if dividers are not enabled
		if (Defaults.SHOW_DIVIDER != 1) { Defaults.DIVIDER_WIDTH = 0; }
		
		if (Defaults.CIRCLE_RADIUS < 0) { Defaults.CIRCLE_RADIUS = 0; }
		if (Defaults.CIRCLE_PADDING < 0) { Defaults.CIRCLE_PADDING = 5; }
		
		// this will make images square as width will be auto-set by grid-view
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
					
		if (Defaults.SHAPE == Defaults.SHAPE_CIRCLE) {
			Defaults.IMAGE_HEIGHT = displayMetrics.widthPixels / Defaults.GRID_SIZE;
			
		} else {
			Defaults.SHAPE = Defaults.SHAPE_SQUARE; 
			Defaults.IMAGE_HEIGHT = (displayMetrics.widthPixels - ((Defaults.GRID_SIZE - 1) * Defaults.DIVIDER_WIDTH)) / Defaults.GRID_SIZE;
		}
		
		Defaults.STATUS_BAR_COLOR = checkTransparentColors(Defaults.STATUS_BAR_COLOR);
		Defaults.BAR_COLOR = checkTransparentColors(Defaults.BAR_COLOR);
		Defaults.BACKGROUND_COLOR = checkTransparentColors(Defaults.BACKGROUND_COLOR);
		Defaults.COVER_VIEW_COLOR = checkTransparentColors(Defaults.COVER_VIEW_COLOR);
		Defaults.CHECKMARK_COLOR = checkTransparentColors(Defaults.CHECKMARK_COLOR);
	}
	
	private static String checkTransparentColors(Object key) {
		if (key instanceof String) {
			String color =  (String) key;
			return (color.equalsIgnoreCase("transparent")) ? "#00000000" : color;	// transparent color hex
		}
		
		return "#00000000";
	}
}






