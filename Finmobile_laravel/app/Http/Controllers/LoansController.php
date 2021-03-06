<?php

namespace App\Http\Controllers;

use App\Model\Loans;
use Illuminate\Http\Request;

class LoansController extends Controller
{
    /**
   * Display a listing of the resource.
   *
   * @return \Illuminate\Http\Response
   */
  public function index()
  {
      return Loans::all();
  }

  /**
   * Show the form for creating a new resource.
   *
   * @return \Illuminate\Http\Response
   */
 


  /**
   * Display the specified resource.
   *
   * @param  \App\Model\Loans  $loans
   * @return \Illuminate\Http\Response
   */
  public function show(Loans $loans)
  {
      try{
          return $loans;
       }
      catch(Exception $e){
          return response('Failed to retrieve',220);
      }
  }
  public function store(Request $request)
  {
      try{
          Loans::create($request->all());
          return response("created",201);
      }
      catch(\Throwable $th){
          return response("failed",220);
      }
  }
/**
   * Show the form for editing the specified resource.
   *
   * @param \Illuminate\Http\Request $request
   * @param  \App\Model\Loans $loans
   * @return \Illuminate\Http\Response
   */
  public function update(Request $request, Loans $loans)
  {
      try{
          $loans->update($request->all());
          return response('updated', 200);
      }
      catch(Exception $e){
          return response('failed to update data', 220);
      }
  }

  /**
   * Remove the specified resource from storage.
   *
   * @param  \App\Model\Loans  $loans
   * @return \Illuminate\Http\Response
   */
  public function destroy(Loans $loans)
  {
      try{
          $loans->delete();
          return response('deleted', 200);
      }
      catch(Exception $e){
          return response('Failed to delete data', 220);
      }
  }
}
