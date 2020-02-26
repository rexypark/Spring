package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private List<String> addressList; // List타입
	private Set<String> addressSet; // Set타입
	private Map<String, String> addressMap; // Map타입
	private Properties addressProp; // Map타입
	
	public CollectionBean() {
		System.out.println(">> CollectionBean() - 객체생성");
		
	}

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	public Set<String> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}

	public Map<String, String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}

	public Properties getAddressProp() {
		return addressProp;
	}

	public void setAddressProp(Properties addressProperties) {
		this.addressProp = addressProperties;
	}
	
	
}
