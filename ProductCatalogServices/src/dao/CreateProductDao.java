package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.google.common.collect.Lists;

import model.CreateProductReturnModel;
import model.DataObject;
import model.ProductObject;
import model.ProductOffering;
import model.ProductOfferingPrice;
import model.ProductSpecCharValue;
import model.ProductSpecCharValueRef;
import model.ProductSpecCharacteristic;
import model.ProductSpecCharacteristicRef;
import model.ProductSpecification;
import model.ProductSpecificationRef;
import model.TimePeriod;
import model.UnitsOfMeasure;

public class CreateProductDao {

	public CreateProductDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	ClientConfig clientConfig = new ClientConfig();
	Client client = ClientBuilder.newClient(clientConfig);

	public ProductObject getProduct(String productSpecification_Id) {

		// instance initialization
		ProductObject productdetails = new ProductObject();

		// Fetch Product and then fetch its offerings
		WebTarget webTarget = client.target(
				"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
				.path("/productSpecification").path(productSpecification_Id);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
		Response response = invocationBuilder.get();
		List<ProductSpecification> productSpecifications = response
				.readEntity(new GenericType<List<ProductSpecification>>() {
				});
		productdetails.setProductSpecification(productSpecifications.get(0));
		System.out.println(productdetails.getProductSpecification().getProductOfferings().get(0).getPOID());
		int numberOfOfferings = productdetails.getProductSpecification().getProductOfferings().size();
		System.out.println("number of offerings" + numberOfOfferings);
		String productOfferingId = null;

		List<ProductOffering> allOfferings = new ArrayList<>();
		ProductOffering productOfferingObject = null;
		for (int i = 0; i < productdetails.getProductSpecification().getProductOfferings().size(); i++) {
			productOfferingId = productdetails.getProductSpecification().getProductOfferings().get(i).getPOID();

			// Fetch offering of the fetched product
			WebTarget productOfferingTarget = client.target(
					"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
					.path("/productOffering").path(productOfferingId);
			Invocation.Builder productOfferingBuilder = productOfferingTarget.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
			Response productOfferingResponse = productOfferingBuilder.get();
			List<ProductOffering> productOfferings = productOfferingResponse
					.readEntity(new GenericType<List<ProductOffering>>() {
					});
			productOfferingObject = new ProductOffering();
			productOfferingObject = productOfferings.get(0);
			allOfferings.add(productOfferingObject);
		}

		productdetails.setProductOffering(allOfferings);

		return productdetails;
	}

	public CreateProductReturnModel createProductWithOrWithoutVarients(DataObject dataObject) {

		/// Creating Instances of Classes
		CreateProductReturnModel createProductReturnModel = new CreateProductReturnModel();
		ProductSpecification productSpecification = new ProductSpecification();
		ProductOffering productOffering = new ProductOffering();
		ProductSpecificationRef productSpecificationRef = new ProductSpecificationRef();

		/// Setting values form request Object Body for productSpecification and product
		/// Offering
		ProductOfferingPrice productOfferingPrice = new ProductOfferingPrice();
		productSpecification.setName(dataObject.getProductName());
		productSpecification.setDescription(dataObject.getProductDescription());
		productSpecification.setIsBundle(dataObject.getProductIsBundle());
		productSpecification.setProductNumber(dataObject.getProductNumber());
		productSpecification.setUnitsOfMeasure(dataObject.getUnitsOfMeasure());
		productSpecification.setProductSpecCharacteristics(dataObject.getProductSpecCharacteristics());
		productOffering.setName(dataObject.getOfferingName());
		productOffering.setDescription(dataObject.getOfferingDescription());
		productOffering.setValidFor(new TimePeriod());
		productOffering.getValidFor().setStartDate(dataObject.getOfferingStartDate());
		productOffering.getValidFor().setEndDate(dataObject.getOfferingEndDate());
		productOffering.setProductSpecifications(new ArrayList<ProductSpecificationRef>());
		productSpecificationRef.setName(productSpecification.getName());
		productSpecificationRef.setDescription(productSpecification.getDescription());
		productSpecificationRef.setProductSerialNumber(productSpecification.getProductNumber());
		productSpecificationRef.setConversionFactor(dataObject.getConversionFactor());
		productOffering.getProductSpecifications().add(productSpecificationRef);
		productOffering.setProductOfferingPrices(new ArrayList<ProductOfferingPrice>());
		productOfferingPrice.setDescription(dataObject.getProductOfferingPriceDescription());
		productOfferingPrice.setName(dataObject.getProductOfferingPriceName());
		productOfferingPrice.setPriceType(dataObject.getProductOfferingPriceType());
		productOfferingPrice.setDutyFreeAmountValue(dataObject.getProductOfferingPriceDutyFreeAmountValue());
		productOfferingPrice.setTaxIncludedAmountValue(dataObject.getProductOfferingPriceTaxIncludedAmountValue());
		productOfferingPrice.setTaxRate(dataObject.getProductOfferingPriceTaxRate());
		productOfferingPrice.setPercentage(dataObject.getProductOfferingPricePercentage());
		productOffering.getProductOfferingPrices().add(productOfferingPrice);
		productOffering.setCategory_Id(dataObject.getCategory_Id());

		// System.out.println("test" + productOffering.toString());

		// Create the product from details

		WebTarget webTarget = client.target(
				"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
				.path("/productSpecification");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
		Response response = invocationBuilder.post(Entity.entity(productSpecification, MediaType.APPLICATION_JSON));
		ProductSpecification responseProduct = new ProductSpecification();
		responseProduct = response.readEntity(ProductSpecification.class);
		productOffering.getProductSpecifications().get(0).setId(responseProduct.getId());
		productOffering.getProductSpecifications().get(0).setProduct_Id(responseProduct.getId());

		// Get the details of Created Product
		WebTarget webTargetProductSpecification = client.target(
				"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
				.path("/productSpecification").path(responseProduct.getId());
		Invocation.Builder invocationBuilderProductSpecification = webTargetProductSpecification
				.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, "Bearer usman");
		Response responseProductSpecification = invocationBuilderProductSpecification.get();
		List<ProductSpecification> productSpecifications = responseProductSpecification
				.readEntity(new GenericType<List<ProductSpecification>>() {
				});
		// ProductSpecification createdProductDetails = new ProductSpecification();
		productSpecification = productSpecifications.get(0);

		// Check for Product if it has some default Characteristics and value

		int numberOfCharacteristics = productSpecification.getProductSpecCharacteristics().size();
		if (numberOfCharacteristics > 0) {
			List<ProductSpecCharacteristic> productSpecCharacteristicList = productSpecification
					.getProductSpecCharacteristics();
			List<List<String>> superlist = new ArrayList<>();
			for (ProductSpecCharacteristic productSpecCharacteristic : productSpecCharacteristicList) {

				List<String> values = new ArrayList<>();

				for (ProductSpecCharValue productCharValue : productSpecCharacteristic.getProductSpecCharValues()) {
					values.add(productSpecCharacteristic.getName() + ":" + productCharValue.getValue() + "="
							+ productSpecCharacteristic.getPOID() + "-" + productCharValue.getPOID());
				}
				superlist.add(values);
			}
			System.out.println("no of characteristics" + productSpecCharacteristicList.size());

			System.out.println(Lists.cartesianProduct(superlist));

			List<List<String>> test = new ArrayList<>();
			test = Lists.cartesianProduct(superlist);
			System.out.print("Number of Possible Varients" + test.size());

			List<ProductSpecCharacteristicRef> productSpecCharacteristicRef = null;
			List<ProductSpecCharValueRef> productSpecCharValueRef = null;

			int looprunning = 0;
			for (int combinations = 0; combinations < test.size(); combinations++) {

				System.out.println(test.get(combinations));
				productSpecCharacteristicRef = new ArrayList<>();
				List<String> values = new ArrayList<>();
				values = test.get(combinations);
				for (int val = 0; val < productSpecCharacteristicList.size(); val++) {
					ProductSpecCharacteristicRef productSpecCharacteristicRefObject = new ProductSpecCharacteristicRef();
					ProductSpecCharValueRef productSpecCharValueRefObject = new ProductSpecCharValueRef();
					productSpecCharValueRef = new ArrayList<>();

					System.out.println("new values" + values.get(val));
					String string = values.get(val);
					String[] splitIntoCharNameAndValue_POIDs = string.split(":");
					String characteristicName = splitIntoCharNameAndValue_POIDs[0];
					String vae = splitIntoCharNameAndValue_POIDs[1];
					String[] characteristicsValue = vae.split("=");
					String value = characteristicsValue[0];
					String POIDs = characteristicsValue[1];
					String[] characteristicsAndValuePOIDs = POIDs.split("-");
					String CharacteristicPOID = characteristicsAndValuePOIDs[0];
					String ValuePOID = characteristicsAndValuePOIDs[1];
					productSpecCharacteristicRefObject.setName(characteristicName);
					productSpecCharacteristicRefObject.setId(CharacteristicPOID);
					productSpecCharValueRefObject.setValue(value);
					productSpecCharValueRefObject.setId(ValuePOID);
					productSpecCharValueRef.add(productSpecCharValueRefObject);
					productSpecCharacteristicRefObject.setProductSpecCharValues(productSpecCharValueRef);
					productSpecCharacteristicRef.add(productSpecCharacteristicRefObject);
					System.out.println("characteristics and its values:" + characteristicName + "---" + value);
					System.out.println("new " + productSpecCharValueRef.toString());
					System.out.println("reference object characteristics" + productSpecCharacteristicRef.toString());
					System.out.println("loop running number of times" + looprunning++);
				}
				System.out.println("--------------------------------------------");
				System.out.println(productSpecCharacteristicRef.toString());
				productOffering.setProductSpecCharacteristicRefs(productSpecCharacteristicRef);
				WebTarget productOfferingTarget = client.target(
						"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
						.path("/productOffering");
				Invocation.Builder productOfferingBuilder = productOfferingTarget.request(MediaType.APPLICATION_JSON)
						.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
				Response productOfferingResponse = productOfferingBuilder
						.post(Entity.entity(productOffering, MediaType.APPLICATION_JSON));
				ProductOffering productOfferingObject = new ProductOffering();
				productOfferingObject = productOfferingResponse.readEntity(ProductOffering.class);
				// productOffering.setId(productOfferingObject.getId());
			}

		} else {
			System.out.println("Empty Characteristics");
			WebTarget productOfferingTarget = client.target(
					"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
					.path("/productOffering");
			Invocation.Builder productOfferingBuilder = productOfferingTarget.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
			Response productOfferingResponse = productOfferingBuilder
					.post(Entity.entity(productOffering, MediaType.APPLICATION_JSON));
			ProductOffering productOfferingObject = new ProductOffering();
			productOfferingObject = productOfferingResponse.readEntity(ProductOffering.class);
			productOffering.setId(productOfferingObject.getId());
		}

		createProductReturnModel.setProductSpecification(productSpecification);
		createProductReturnModel.setProductOffering(productOffering);

		return createProductReturnModel;
	}

	public List<UnitsOfMeasure> getUnitOfMeasuresOfProduct(String productId) {
		WebTarget webTarget = client.target(
				"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
				.path("/productSpecification").path(productId);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
		Response response = invocationBuilder.get();
		List<ProductSpecification> productSpecifications = response
				.readEntity(new GenericType<List<ProductSpecification>>() {
				});

		return productSpecifications.get(0).getUnitsOfMeasure();
	}

	public List<ProductSpecification> searchByName(String name) {

		WebTarget webTarget = client.target(
				"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
				.path("/productSpecifications");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
		Response response = invocationBuilder.get();
		List<ProductSpecification> productSpecifications = response
				.readEntity(new GenericType<List<ProductSpecification>>() {
				});
		System.out.println("name by search"+name);
		List<ProductSpecification> productSpecificationsByName=new ArrayList<>();
		for(ProductSpecification productSpecification:productSpecifications)
		{		
			if(name.equals(productSpecification.getName()))
			{
				System.out.println("Product found in record"+productSpecification.getName());
				productSpecificationsByName.add(productSpecification);
			}
		}
		return productSpecificationsByName;
	}
}
