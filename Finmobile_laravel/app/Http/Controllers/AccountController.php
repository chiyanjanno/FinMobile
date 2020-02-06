<?php

namespace App\Http\Controllers;

use App\Model\Account;
use Illuminate\Http\Request;

class AccountController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return Account::all();
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
   
    public function store(Request $request)
    {
        try{
            Account::create($request->all());
            return response("created",201);
        }
        catch(\Throwable $th){
            return response("failed",220);
        }
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Model\Account  $account
     * @return \Illuminate\Http\Response
     */
    public function show(Account $account)
    {
        try{
            return $account;
         }
        catch(Exception $e){
            return response('Failed to retrieve',220);
        }
    }
  /**
     * Show the form for editing the specified resource.
     *
     * @param \Illuminate\Http\Request $request
     * @param  \App\Model\Account  $account
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Account $account)
    {
        try{
            $account->update($request->all());
            return response('updated', 200);
        }
        catch(Exception $e){
            return response('failed to update data', 220);
        }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Model\Account  $account
     * @return \Illuminate\Http\Response
     */
    public function destroy(Account $account)
    {
        try{
            $account->delete();
            return response('deleted', 200);
        }
        catch(Exception $e){
            return response('Failed to delete data', 220);
        }
    }
}
