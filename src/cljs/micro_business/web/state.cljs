(ns micro-business.web.state)

(def applicationGlobalState
  {:root-view
   {:signedOut {:id :signedOut
                :navigationBars [{:id "topNavigationBar"
                                  :brand "Micro Business"
                                  :rightToLeftAlignment false
                                  :navigationItems [{:id "signin" :caption "Sign in" :onClickedQueryExpression `[('signin/clicked) :root-view]}]}]}

    :signedIn {:id :signedIn
               :navigationBars [{:id "topNavigationBar"
                                 :brand "Micro Business"
                                 :rightToLeftAlignment false
                                 :navigationItems [{:id "signout" :caption "Sign out" :onClickedQueryExpression `[('signout/clicked) :root-view]}]}]}}})
