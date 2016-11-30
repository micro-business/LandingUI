(ns micro-business.web.signedin.state)

(def state
  {:id :signedInRootView
   :navigationBars [{:id "topNavigationBar"
                     :brand "Micro Business"
                     :rightToLeftAlignment false
                     :navigationItems [{:id "signout" :caption "Sign out" :onClickedQueryExpression `[('signout/clicked) :root-view]}]}]})
