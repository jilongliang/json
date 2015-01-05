package ivyy.taobao.com.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *@Email:jilongliang@sina.com
 *@Date:2015-1-5
 *@CopyRight:liangjilong
 *@Description:ͨ��json-libȥ��װ��JSON��JAVA��POJO���໥ת��JSONHelper.java
 */
@SuppressWarnings("all")
public final class JSONHelper {
	private static final Log logger = LogFactory.getLog(JSONHelper.class);
	/**
	 * ������ת����JSON
	 * @param object
	 * @return
	 */
	public static String array2json(Object object) {
		JSONArray jsonArray = JSONArray.fromObject(object);
		return jsonArray.toString();
	}

	/**
	 *  ��JSONת��������,����valueClzΪ�����д�ŵĶ����Class
	 * @param json
	 * @param valueClz
	 * @return
	 */
	public static Object json2Array(String json, Class valueClz) {
		JSONArray jsonArray = JSONArray.fromObject(json);
		return JSONArray.toArray(jsonArray, valueClz);
	}

	/**
	 *  ��Collectionת����JSON
	 * @param object
	 * @return
	 */
	public static String collection2json(Object object) {
		JSONArray jsonArray = JSONArray.fromObject(object);
		return jsonArray.toString();
	}

	/**
	 *  ��Mapת����JSON
	 * @param object
	 * @return
	 */
	public static String map2json(Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}

	/**
	 *  ��JSONת����Map,����valueClzΪMap��value��Class,keyArrayΪMap��key
	 * @param keyArray
	 * @param json
	 * @param valueClz
	 * @return
	 */
	public static Map json2Map(Object[] keyArray, String json, Class valueClz) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		Map classMap = new HashMap();

		for (int i = 0; i < keyArray.length; i++) {
			classMap.put(keyArray[i], valueClz);
		}

		return (Map) JSONObject.toBean(jsonObject, Map.class, classMap);
	}

	/**
	 *  ��POJOת����JSON
	 * @param object
	 * @return
	 */
	public static String bean2json(Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}

	/**
	 *  ��JSONת����POJO,����beanClzΪPOJO��Class
	 * @param json
	 * @param beanClz
	 * @return
	 */
	public static Object json2Object(String json, Class beanClz) {
		return JSONObject.toBean(JSONObject.fromObject(json), beanClz);
	}

	/**
	 * jsonת��Ϊjava����
	 * 
	 * <pre>
	 * return JackJson.fromJsonToObject(this.answersJson, JackJson.class);
	 * </pre>
	 * 
	 * @param <T>
	 *            Ҫת���Ķ���
	 * @param json
	 *            �ַ���
	 * @param valueType
	 *            �����class
	 * @return ���ض���
	 */
	public static <T> T fromJsonToObject(String json, Class<T> valueType) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, valueType);
		} catch (JsonParseException e) {
			logger.error("JsonParseException: ", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		}
		return null;
	}

	/**��Stringת����JSON
	 * @param key
	 * @param value
	 * @return
	 */
	public static String string2json(String key, String value) {
		JSONObject object = new JSONObject();
		object.put(key, value);
		return object.toString();
	}

	/**
	 *  ��JSONת����String
	 * @param json
	 * @param key
	 * @return
	 */
	public static String json2String(String json, String key) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		return jsonObject.get(key).toString();
	}

	/***
	 * ��List�������л�ΪJSON�ı�
	 */
	public static <T> String toJSONString(List<T> list) {
		JSONArray jsonArray = JSONArray.fromObject(list);

		return jsonArray.toString();
	}

	/***
	 * ���������л�ΪJSON�ı�
	 * 
	 * @param object
	 * @return
	 */
	public static String toJSONString(Object object) {
		JSONArray jsonArray = JSONArray.fromObject(object);

		return jsonArray.toString();
	}

	/***
	 * ��JSON�����������л�ΪJSON�ı�
	 * 
	 * @param jsonArray
	 * @return
	 */
	public static String toJSONString(JSONArray jsonArray) {
		return jsonArray.toString();
	}

	/***
	 * ��JSON�������л�ΪJSON�ı�
	 * 
	 * @param jsonObject
	 * @return
	 */
	public static String toJSONString(JSONObject jsonObject) {
		return jsonObject.toString();
	}

	/***
	 * ������ת��ΪList����
	 * 
	 * @param object
	 * @return
	 */
	public static List toArrayList(Object object) {
		List arrayList = new ArrayList();

		JSONArray jsonArray = JSONArray.fromObject(object);

		Iterator it = jsonArray.iterator();
		while (it.hasNext()) {
			JSONObject jsonObject = (JSONObject) it.next();

			Iterator keys = jsonObject.keys();
			while (keys.hasNext()) {
				Object key = keys.next();
				Object value = jsonObject.get(key);
				arrayList.add(value);
			}
		}

		return arrayList;
	}

	/* *//***
	 * ������ת��ΪCollection����
	 * 
	 * @param object
	 * @return
	 */
	/*
	 * public static Collection toCollection(Object object) { JSONArray
	 * jsonArray = JSONArray.fromObject(object);
	 * 
	 * return JSONArray.toCollection(jsonArray); }
	 */

	/***
	 * ������ת��ΪJSON��������
	 * 
	 * @param object
	 * @return
	 */
	public static JSONArray toJSONArray(Object object) {
		return JSONArray.fromObject(object);
	}

	/***
	 * ������ת��ΪJSON����
	 * 
	 * @param object
	 * @return
	 */
	public static JSONObject toJSONObject(Object object) {
		return JSONObject.fromObject(object);
	}

	/***
	 * ������ת��ΪHashMap
	 * 
	 * @param object
	 * @return
	 */
	public static HashMap toHashMap(Object object) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		JSONObject jsonObject = JSONHelper.toJSONObject(object);
		Iterator it = jsonObject.keys();
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value = jsonObject.get(key);
			data.put(key, value);
		}

		return data;
	}

	/***
	 * ������ת��ΪList<Map<String,Object>>
	 * ���ط�ʵ������(Map<String,Object>)��List
	 * @param object
	 * @return
	 */
	public static List<Map<String, Object>> toList(Object object) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		JSONArray jsonArray = JSONArray.fromObject(object);
		for (Object obj : jsonArray) {
			JSONObject jsonObject = (JSONObject) obj;
			Map<String, Object> map = new HashMap<String, Object>();
			Iterator it = jsonObject.keys();
			while (it.hasNext()) {
				String key = (String) it.next();
				Object value = jsonObject.get(key);
				map.put((String) key, value);
			}
			list.add(map);
		}
		return list;
	}

	/***
	 * ��JSON��������ת��Ϊ�������͵�List
	 * 
	 * @param <T>
	 * @param jsonArray
	 * @param objectClass
	 * @return
	 */
	public static <T> List<T> toList(JSONArray jsonArray, Class<T> objectClass) {
		return JSONArray.toList(jsonArray, objectClass);
	}

	/***
	 * ������ת��Ϊ�������͵�List
	 * 
	 * @param <T>
	 * @param jsonArray
	 * @param objectClass
	 * @return
	 */
	public static <T> List<T> toList(Object object, Class<T> objectClass) {
		JSONArray jsonArray = JSONArray.fromObject(object);

		return JSONArray.toList(jsonArray, objectClass);
	}

	/***
	 * ��JSON����ת��Ϊ�������͵Ķ���
	 * 
	 * @param <T>
	 * @param jsonObject
	 * @param beanClass
	 * @return
	 */
	public static <T> T toBean(JSONObject jsonObject, Class<T> beanClass) {
		return (T) JSONObject.toBean(jsonObject, beanClass);
	}

	/***
	 * ��������ת��Ϊ�������͵Ķ���
	 * 
	 * @param <T>
	 * @param object
	 * @param beanClass
	 * @return
	 */
	public static <T> T toBean(Object object, Class<T> beanClass) {
		JSONObject jsonObject = JSONObject.fromObject(object);

		return (T) JSONObject.toBean(jsonObject, beanClass);
	}

	/***
	 * ��JSON�ı������л�Ϊ���ӹ�ϵ��ʵ��
	 * 
	 * @param <T>
	 *            ����T ������ʵ������
	 * @param <D>
	 *            ����D �����ʵ������
	 * @param jsonString
	 *            JSON�ı�
	 * @param mainClass
	 *            ��ʵ������
	 * @param detailName
	 *            ��ʵ��������ʵ�����е���������
	 * @param detailClass
	 *            ��ʵ������
	 * @return
	 */
	public static <T, D> T toBean(String jsonString, Class<T> mainClass,
			String detailName, Class<D> detailClass) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		JSONArray jsonArray = (JSONArray) jsonObject.get(detailName);

		T mainEntity = JSONHelper.toBean(jsonObject, mainClass);
		List<D> detailList = JSONHelper.toList(jsonArray, detailClass);

		try {
			BeanUtils.setProperty(mainEntity, detailName, detailList);
		} catch (Exception ex) {
			throw new RuntimeException("���ӹ�ϵJSON�����л�ʵ��ʧ�ܣ�");
		}

		return mainEntity;
	}

	/***
	 * ��JSON�ı������л�Ϊ���ӹ�ϵ��ʵ��
	 * 
	 * @param <T>����T ������ʵ������
	 * @param <D1>����D1 �����ʵ������
	 * @param <D2>����D2 �����ʵ������
	 * @param jsonString
	 *            JSON�ı�
	 * @param mainClass
	 *            ��ʵ������
	 * @param detailName1
	 *            ��ʵ��������ʵ�����е�����
	 * @param detailClass1
	 *            ��ʵ������
	 * @param detailName2
	 *            ��ʵ��������ʵ�����е�����
	 * @param detailClass2
	 *            ��ʵ������
	 * @return
	 */
	public static <T, D1, D2> T toBean(String jsonString, Class<T> mainClass,
			String detailName1, Class<D1> detailClass1, String detailName2,
			Class<D2> detailClass2) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(detailName1);
		JSONArray jsonArray2 = (JSONArray) jsonObject.get(detailName2);

		T mainEntity = JSONHelper.toBean(jsonObject, mainClass);
		List<D1> detailList1 = JSONHelper.toList(jsonArray1, detailClass1);
		List<D2> detailList2 = JSONHelper.toList(jsonArray2, detailClass2);

		try {
			BeanUtils.setProperty(mainEntity, detailName1, detailList1);
			BeanUtils.setProperty(mainEntity, detailName2, detailList2);
		} catch (Exception ex) {
			throw new RuntimeException("���ӹ�ϵJSON�����л�ʵ��ʧ�ܣ�");
		}

		return mainEntity;
	}

	/***
	 * ��JSON�ı������л�Ϊ���ӹ�ϵ��ʵ��
	 * 
	 * @param <T>����T ������ʵ������
	 * @param <D1>����D1 �����ʵ������
	 * @param <D2>����D2 �����ʵ������
	 * @param jsonString
	 *            JSON�ı�
	 * @param mainClass
	 *            ��ʵ������
	 * @param detailName1
	 *            ��ʵ��������ʵ�����е�����
	 * @param detailClass1
	 *            ��ʵ������
	 * @param detailName2
	 *            ��ʵ��������ʵ�����е�����
	 * @param detailClass2
	 *            ��ʵ������
	 * @param detailName3
	 *            ��ʵ��������ʵ�����е�����
	 * @param detailClass3
	 *            ��ʵ������
	 * @return
	 */
	public static <T, D1, D2, D3> T toBean(String jsonString,
			Class<T> mainClass, String detailName1, Class<D1> detailClass1,
			String detailName2, Class<D2> detailClass2, String detailName3,
			Class<D3> detailClass3) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(detailName1);
		JSONArray jsonArray2 = (JSONArray) jsonObject.get(detailName2);
		JSONArray jsonArray3 = (JSONArray) jsonObject.get(detailName3);

		T mainEntity = JSONHelper.toBean(jsonObject, mainClass);
		List<D1> detailList1 = JSONHelper.toList(jsonArray1, detailClass1);
		List<D2> detailList2 = JSONHelper.toList(jsonArray2, detailClass2);
		List<D3> detailList3 = JSONHelper.toList(jsonArray3, detailClass3);

		try {
			BeanUtils.setProperty(mainEntity, detailName1, detailList1);
			BeanUtils.setProperty(mainEntity, detailName2, detailList2);
			BeanUtils.setProperty(mainEntity, detailName3, detailList3);
		} catch (Exception ex) {
			throw new RuntimeException("���ӹ�ϵJSON�����л�ʵ��ʧ�ܣ�");
		}

		return mainEntity;
	}

	/***
	 * ��JSON�ı������л�Ϊ���ӹ�ϵ��ʵ��
	 * 
	 * @param <T>
	 *            ��ʵ������
	 * @param jsonString
	 *            JSON�ı�
	 * @param mainClass
	 *            ��ʵ������
	 * @param detailClass
	 *            ����˶����ʵ������ʵ�����������ƺ�����
	 * @return
	 */
	public static <T> T toBean(String jsonString, Class<T> mainClass,
			HashMap<String, Class> detailClass) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		T mainEntity = JSONHelper.toBean(jsonObject, mainClass);
		for (Object key : detailClass.keySet()) {
			try {
				Class value = (Class) detailClass.get(key);
				BeanUtils.setProperty(mainEntity, key.toString(), value);
			} catch (Exception ex) {
				throw new RuntimeException("���ӹ�ϵJSON�����л�ʵ��ʧ�ܣ�");
			}
		}
		return mainEntity;
	}

}