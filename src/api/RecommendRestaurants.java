package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.DBConnection;
import db.MongoDBConnection;
import db.MySQLDBConnection;

/**
 * Servlet implementation class RecommendRestaurants
 */

@WebServlet("/recommendation")

public class RecommendRestaurants extends HttpServlet {
//	public Restaurant(String businessId, String name, String categories,
//	   		 String city, String state, double stars, String fullAddress, 
//	   		 double latitude, double longitude, String imageUrl, String url) {
//	   
//	   	 this.businessId = businessId;
//	   	 this.name = name;
//	   	 this.categories = categories;
//	   	 this.city = city;
//	   	 this.state = state;
//	   	 this.fullAddress = fullAddress;
//	   	 this.stars = stars;
//	   	 this.latitude = latitude;
//	   	 this.longitude = longitude;
//	   	 this.imageUrl = imageUrl;
//	   	 this.url = url;
//	    }
	private static final long serialVersionUID = 1L;
	//private static DBConnection connection = new MySQLDBConnection(); 
	DBConnection connection = new MongoDBConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendRestaurants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

    	JSONArray array = null;
    	if (request.getParameterMap().containsKey("user_id")) {
    		String userId = request.getParameter("user_id");
    		array = connection.recommendRestaurants(userId);
    	}
    	RpcParser.writeOutput(response, array);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
