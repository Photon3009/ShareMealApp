package com.example.sharemeal

sealed class Screen(val route:String)
{
    object Home: Screen(route="first_page")
    object Dlogin: Screen(route="Dlogin")
    object DRegisterScreen:Screen(route="Dregister")
    object NRegisterScreen:Screen(route="Nregister")
    object Nlogin: Screen(route="Nlogin")
    object DMenu:Screen(route="DMenu")
    object DDonate:Screen(route="DDonate")
    object DHistoryScreen:Screen(route="DHistory")
    object NMenu:Screen(route="NMenu")
    object DStatus:Screen(route="DStatus")
    object CheckDonations:Screen(route="CheckDonations")
}