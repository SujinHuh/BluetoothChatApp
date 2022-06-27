package com.keti.bluetoothchatapp

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var bluetoothAdapter : BluetoothAdapter //lateinit 초기화

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)S

        initBluetooth()
    }

    private fun initBluetooth() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "No bluetooth found", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_search_devices -> {
                Toast.makeText(this, "Clicked Search Devices", Toast.LENGTH_LONG).show()
//                checkPermissions()
                true
            }
            R.id.menu_enable_bluetooth -> {
                Toast.makeText(this, "Clicked Enable Blutooth", Toast.LENGTH_LONG).show()
                enableBluetooth()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun enableBluetooth() {
        if (!bluetoothAdapter!!.isEnabled) {
            Toast.makeText(this, "BT 이미 활성화 됨", Toast.LENGTH_LONG).show()
        }
        else{
//            bluetoothAdapter.enable()
        }
      /*  if (bluetoothAdapter!!.scanMode != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
            val discoveryIntent = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE)
            discoveryIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300)
            startActivity(discoveryIntent)
        }*/
    }

}