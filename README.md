# Secure DB
Secure DB aims to provide encrypted database using native development kit. Data can be stored in key-value pair in a secured way.

## Add Dependency
```
implementation 'com.github.tusharmehta02:secureDB:1.0.0'
```

## Initialize SecureDB
Should be initialized once in `Application.onCreate()`:
```
SecuredDataManager.install(this)
```
## Usage
```
class MainActivity : AppCompatActivity(), DataLoadListener {

    lateinit var secureDataInteractionManager:  SecureDataInteractionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        secureDataInteractionManager = DBHelper.getInstance(this, stringFromJNIClass())
        val pair  = secureDataInteractionManager.getDataSync("13")
        tvKey.text = "Key: "+ pair.first
        tvValue.text = "Value: "+ pair.second
    }



    external fun stringFromJNIClass(): String


    override fun onDataLoaded(pair: Pair<String, String?>) {
       Log.d(TAG, pair.first +"  "+ pair.second)
    }


    override fun onDestroy() {
        super.onDestroy()
        secureDataInteractionManager.closeDB()
    }

    companion object {
        val TAG = MainActivity.javaClass.simpleName
    }
}
```
