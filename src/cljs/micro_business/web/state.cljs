(ns micro-business.web.state)

(def applicationGlobalState
  {:root-view
   {:signedOut {:id :signedOut
                :navigationBars [{:id "topNavigationBar"
                                  :brand "Micro Business"
                                  :rightToLeftAlignment false
                                  :navigationItems [{:id "signin" :caption "Sign in" :onClickedDispatchKey 'signin/clicked}]}]}

    :signedIn {:id :signedIn
               :navigationBars [{:id "topNavigationBar"
                                 :brand "Micro Business"
                                 :rightToLeftAlignment false
                                 :navigationItems [{:id "signout" :caption "Sign out" :onClickedDispatchKey 'signout/clicked}]}]}}})
