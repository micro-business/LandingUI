(ns micro-business.web.landingpage.state)

(def state
  {:signedInLandingPage
   {:id :signedInLandingPage
    :navigationBars [{:id "topNavigationBar"
                      :brand "Micro Business"
                      :rightToLeftAlignment false
                      :navigationItems [{:id "signout" :caption "Sign out" :onClickedQueryExpression `[('signout/clicked) :root-view]}]}]}

   :signedOutLandingPage
   {:id :signedOutLandingPage
    :navigationBars [{:id "topNavigationBar"
                      :brand "Micro Business"
                      :rightToLeftAlignment false
                      :navigationItems [{:id "signin" :caption "Sign in" :onClickedQueryExpression `[('signin/clicked) :root-view]}]}]}})
