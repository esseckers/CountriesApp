package com.countrytable.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.countrytable.R;
import com.countrytable.model.Country;
import com.countrytable.view.Utils;
import com.countrytable.view.annotation.Layout;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.Bind;

@Layout(R.layout.fragm_map)
public class MainMapFragment extends AbstractFragment {

    public Country country;

    @Bind(R.id.map)
    MapView map;

    @Override
    protected void initView(View view, Bundle bundle) {
        country = (Country) getArguments().getSerializable(Utils.BUNDLE_KEY);
        MapsInitializer.initialize(getActivity());
        switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity())) {
            case ConnectionResult.SUCCESS:
                map.onCreate(bundle);
                break;
            case ConnectionResult.SERVICE_MISSING:
                Toast.makeText(getActivity(), "SERVICE MISSING", Toast.LENGTH_SHORT).show();
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
                Toast.makeText(getActivity(), "UPDATE REQUIRED", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getActivity(), GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onResume() {
        map.onResume();
        super.onResume();
        if (map != null) {
            GoogleMap googleMap = map.getMap();
            LatLng latLng = new LatLng(country.getCityLatitude(), country.getCityLongitude());
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13.0f));
            googleMap.addMarker(new MarkerOptions().position(latLng).title(country.getCityName()).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        map.onLowMemory();
    }
}
