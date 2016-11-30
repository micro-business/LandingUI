(ns micro-business.web.signedout.state)

(def state
  {:id :signedOutRootView
   :navigationBars [{:id "topNavigationBar"
                     :brand "Micro Business"
                     :rightToLeftAlignment false
                     :navigationItems [{:id "signin" :caption "Sign in" :onClickedQueryExpression `[('signin/clicked) :root-view]}]}]})
